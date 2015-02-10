/*
 * Copyright (c) 2010-2011. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.axonframework.sample.app.command;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.sample.app.api.Address;
import org.axonframework.sample.app.api.AddressAddedEvent;
import org.axonframework.sample.app.api.AddressChangedEvent;
import org.axonframework.sample.app.api.AddressRegisteredEvent;
import org.axonframework.sample.app.api.AddressRemovedEvent;
import org.axonframework.sample.app.api.AddressType;
import org.axonframework.sample.app.api.ContactCreatedEvent;
import org.axonframework.sample.app.api.ContactDeletedEvent;
import org.axonframework.sample.app.api.ContactNameChangedEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>The Aggregate root component of the sample application. This component handles all contact as well as address
 * domain events.</p>
 *
 * @author Allard Buijze
 */
class Contact extends AbstractAnnotatedAggregateRoot<String> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Map<AddressType, Address> addresses = new HashMap<AddressType, Address>();
    private String id;

    public Contact(String identifier, String name) {
        apply(new ContactCreatedEvent(identifier, name));
    }

//    @SuppressWarnings("UnusedDeclaration")
    Contact() {
    }

    /**
     * Register the provided address with the provided type. If a contact already has an address of the provided type,
     * that address is changed.
     *
     * @param type    AddressType of the address to add or change
     * @param address Address to add or change
     */
    public void registerAddress(AddressType type, Address address) {
        if (addresses.containsKey(type)) {
            apply(new AddressChangedEvent(id, type, address));
        } else {
            apply(new AddressAddedEvent(id, type, address));
        }
    }

    /**
     * Removes the address with the provided type if it exists.
     *
     * @param type AddressType of the address that needs to be removed
     */
    public void removeAddress(AddressType type) {
        if (addresses.containsKey(type)) {
            apply(new AddressRemovedEvent(id, type));
        }
    }

    /**
     * Change the name of the contact
     *
     * @param name String containing the new name
     */
    public void changeName(String name) {
        apply(new ContactNameChangedEvent(id, name));
    }

    public void delete() {
        apply(new ContactDeletedEvent(id));
    }

    @EventHandler
    protected void handleContactCreatedEvent(ContactCreatedEvent event) {
        this.id = event.getContactId();
    }

    @EventHandler
    protected void handleContactNameChangedEvent(ContactNameChangedEvent event) {
    }

    @EventHandler
    protected void handleAddressRegisteredEvent(AddressRegisteredEvent event) {
        addresses.put(event.getType(), event.getAddress());
    }

    @EventHandler
    protected void handleAddressRemovedEvent(AddressRemovedEvent event) {
        addresses.remove(event.getType());
    }

    public String getIdentifier() {
        return id;
    }
}
