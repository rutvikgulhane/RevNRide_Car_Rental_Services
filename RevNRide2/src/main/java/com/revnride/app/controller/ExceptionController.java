package com.revnride.app.controller;

import java.text.ParseException;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.revnride.app.dto.response.MessageResponse;
import com.revnride.app.exception.WrongDataException;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;


@ControllerAdvice
@Slf4j
@Log4j2
public class ExceptionController {

    @ExceptionHandler(value = {ParseException.class , DataAccessException.class , IllegalArgumentException.class, WrongDataException.class})
    public ResponseEntity<MessageResponse> exception(RuntimeException exception) {
        log.info(exception.getMessage());
        return new ResponseEntity<>(new MessageResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
