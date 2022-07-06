package org.agrotechfields.report.exception;

public class InactiveIslandException extends RuntimeException{
  public InactiveIslandException(){
    super("Island is inactive");
  }
}
