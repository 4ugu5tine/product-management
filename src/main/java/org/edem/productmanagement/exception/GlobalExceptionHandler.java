//package org.edem.productmanagement.exception;
//
//import org.springframework.http.*;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.util.List;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler ResponseEntityExceptionHandler{
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException ex,
//            HttpHeaders headers,
//            HttpStatusCode status,
//            WebRequest request) {
//
//        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
//                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
//                .toList();
//        return exceptionResponse(HttpStatus.BAD_REQUEST, String.join(", ", errors));
//    }
//    private ResponseEntity<Object> exceptionResponse(HttpStatus status, String details) {
//        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
//        problemDetail.setDetail(details);
//        return ResponseEntity.status(status).body(problemDetail);
//    }
//
//    @ExceptionHandler({CategoryNotFoundException.class})
//    public ResponseEntity<Object> handle404Exceptions(Exception e) {
//        return exceptionResponse(HttpStatus.NOT_FOUND, e.getMessage());
//    }
//
//}
