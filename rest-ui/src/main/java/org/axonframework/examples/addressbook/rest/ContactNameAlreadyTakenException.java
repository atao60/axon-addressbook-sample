package org.axonframework.examples.addressbook.rest;

/**
 * @author Jettro Coenradie
 */
public class ContactNameAlreadyTakenException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ContactNameAlreadyTakenException(String s) {
        super("The choosen contact name has already been taken:" + s);
    }
}
