package com.futurodev.crm.exception;

import com.futurodev.crm.dto.ErrorDto;
import com.futurodev.crm.exception.error.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        return ResponseEntity.badRequest().body(
                ErrorDto.builder()
                        .code("400")
                        .message(e.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ErrorDto.builder()
                        .code("404")
                        .message(e.getMessage())
                        .build()
        );
    }

}
