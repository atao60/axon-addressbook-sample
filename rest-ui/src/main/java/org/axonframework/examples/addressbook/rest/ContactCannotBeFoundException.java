package org.axonframework.examples.addressbook.rest;

/**
 * @author Jettro Coenradie
 */
public class ContactCannotBeFoundException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ContactCannotBeFoundException(String s) {
        super("Contact cannot be found : " + s);
    }
}
