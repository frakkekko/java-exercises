package org.app.exceptions;

public class OddSizeListException extends RuntimeException {

    public OddSizeListException(){
        super("Cannot resolve odd size list");
    }
}
