package org.edem.productmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCategoryNotFoundException(CategoryNotFoundException exception){
        ErrorResponse response = new ErrorResponse(
                exception.getMessage(),
                LocalDateTime.now(),
                "Could not find the requested category");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}
