package org.agrotechfields.report.exception;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(){
        super("Id not found");
    }
}
