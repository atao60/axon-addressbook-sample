/*
 * Copyright (c) 2010. Axon Framework
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

package org.axonframework.examples.addressbook.web.dto;

import org.axonframework.sample.app.api.Address;
import org.axonframework.sample.app.api.AddressType;
import org.axonframework.sample.app.query.AddressEntry;

import java.io.Serializable;

/**
 * @author Jettro Coenradie
 */
public class AddressDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String contactName;
    private String contactUUID;

    private AddressType type;
    private String street;
    private String city;
    private String zipCode;

    public AddressDTO() {
    }

    public static AddressDTO createFrom(AddressEntry addressEntry) {
        AddressDTO newAddress = new AddressDTO();
        newAddress.setType(addressEntry.getAddressType());
        newAddress.setCity(addressEntry.getCity());
        newAddress.setContactName(addressEntry.getName());
        newAddress.setStreet(addressEntry.getStreetAndNumber());
        newAddress.setZipCode(addressEntry.getZipCode());
        newAddress.setContactUUID(addressEntry.getIdentifier());

        return newAddress;
    }

    public static AddressDTO createFrom(Address address, String contactIdentifier,
                                        AddressType addressType) {
        AddressDTO newAddress = new AddressDTO();
        newAddress.setContactUUID(contactIdentifier);
        newAddress.setStreet(address.getStreetAndNumber());
        newAddress.setZipCode(address.getZipCode());
        newAddress.setCity(address.getCity());
        newAddress.setType(addressType);
        return newAddress;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactUUID() {
        return contactUUID;
    }

    public void setContactUUID(String contactUUID) {
        this.contactUUID = contactUUID;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }
}
