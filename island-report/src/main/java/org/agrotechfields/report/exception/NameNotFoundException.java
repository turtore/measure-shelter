package org.agrotechfields.report.exception;

public class NameNotFoundException extends RuntimeException{
  public NameNotFoundException(){
    super("No island found");
  }
}
