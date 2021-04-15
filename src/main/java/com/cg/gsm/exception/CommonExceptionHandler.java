package com.cg.gsm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {

@ExceptionHandler(UserNotFoundException.class)
public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(UserNotFoundException ex, WebRequest req) {
    ExceptionResponse expResp = new ExceptionResponse(ex.getMessage(),"User does Not Exists");
    return new ResponseEntity(expResp,HttpStatus.OK);
}

@ExceptionHandler(ProductNotFoundException.class)
public final ResponseEntity<ExceptionResponse> handleRecordNotFoundException(ProductNotFoundException ex, WebRequest req) {
    ExceptionResponse expResp = new ExceptionResponse(ex.getMessage(),"Product does Not Exists");
    return new ResponseEntity(expResp,HttpStatus.OK);
}

@ExceptionHandler(Exception.class)
public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest req) {
    ExceptionResponse expResp = new ExceptionResponse(ex.getMessage(),"Detail Description of the Exception");
    return new ResponseEntity(expResp,HttpStatus.INTERNAL_SERVER_ERROR);
}

@ExceptionHandler(OutofStockException.class)
public final ResponseEntity<ExceptionResponse> handleOutofStockException(OutofStockException ex, WebRequest req) {
    ExceptionResponse expResp = new ExceptionResponse(ex.getMessage(),"Please book with less quanity");
    return new ResponseEntity(expResp,HttpStatus.OK);
}

}
