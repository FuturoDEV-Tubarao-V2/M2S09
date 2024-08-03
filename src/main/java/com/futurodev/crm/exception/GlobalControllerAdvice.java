package com.futurodev.crm.exception;

import com.futurodev.crm.dto.ErrorDto;
import com.futurodev.crm.exception.error.NotFoundException;
import com.futurodev.crm.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        ErrorDto error = ErrorDto.builder().code("400").message(e.getMessage()).build();

        log.error(JsonUtil.toJson(error));
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleException(NotFoundException e) {
        ErrorDto error = ErrorDto.builder().code("404").message(e.getMessage()).build();

        log.error(JsonUtil.toJson(error));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
