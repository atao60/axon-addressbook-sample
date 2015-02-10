/*
 * Copyright (c) 2010. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
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
 * <p>Value object representing an address.</p>
 *
 * @author Allard Buijze
 */
public class Address implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String streetAndNumber;
    private String zipCode;
    private String city;

    public Address(String streetAndNumber, String zipCode, String city) {
        this.streetAndNumber = streetAndNumber;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }
}
