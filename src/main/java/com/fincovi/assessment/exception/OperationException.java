package com.fincovi.assessment.exception;

import org.springframework.http.HttpStatus;

public class OperationException extends RuntimeException {


  private final String message;
  private final HttpStatus httpStatus;

  public OperationException(String message, HttpStatus httpStatus) {
    this.message = message;
    this.httpStatus = httpStatus;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

}
