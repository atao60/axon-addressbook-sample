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

package org.axonframework.sample.app.api;

import java.io.Serializable;

/**
 * @author Allard Buijze
 */
public class ContactCreatedEvent implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final String contactId;
    private final String name;

    public ContactCreatedEvent(String contactId, String name) {
        this.contactId = contactId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getContactId() {
        return contactId;
    }
}
