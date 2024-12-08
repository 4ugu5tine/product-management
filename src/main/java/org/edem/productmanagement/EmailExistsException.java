package org.edem.productmanagement;

public class EmailExistsException extends RuntimeException{
    public EmailExistsException(String message) {
        super(message);
    }
}
