package org.app.exceptions;

public class MaxMinCalcException extends RuntimeException{

    public MaxMinCalcException(){
        super("An error occurred in max/min calculation");
    }
}
