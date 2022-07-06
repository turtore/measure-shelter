package org.agrotechfields.report.exception;

public class EmptyNameException extends RuntimeException{
  public EmptyNameException(){
    super("Name cannot be Blank");
  }
}
