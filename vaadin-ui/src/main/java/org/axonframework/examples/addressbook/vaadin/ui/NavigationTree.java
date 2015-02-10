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

package org.axonframework.examples.addressbook.vaadin.ui;

import com.vaadin.ui.Tree;

/**
 * @author Jettro Coenradie
 */
public class NavigationTree extends Tree {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final Object SHOW_ALL = "Show all";
    public static final Object SEARCH = "Search";

    public NavigationTree() {
        addItem(SHOW_ALL);
        addItem(SEARCH);
        setSelectable(true);
        setNullSelectionAllowed(false);
    }
}
