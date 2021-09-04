package com.utkarsh.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation", "rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception exception,
                                                            WebRequest request) {
        List<String> details = new ArrayList<>();

        details.add(exception.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Internal Server Error", details);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException exception,
                                                                      WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(exception.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Record Not Found", details);

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                      HttpHeaders headers,
                                                                      HttpStatus status,
                                                                      WebRequest request) {
        List<String> details = new ArrayList<>();

        for (ObjectError er: exception.getBindingResult().getAllErrors()) {
            details.add(er.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse("Object Validation failed", details);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }


}
