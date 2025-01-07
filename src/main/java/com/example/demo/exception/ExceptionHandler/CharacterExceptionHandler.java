package com.example.demo.exception.ExceptionHandler;

import com.example.demo.exception.CharacterAlreadyExistsException;
import com.example.demo.exception.CharacterNotFoundException;
import com.example.demo.exception.CharacterObjectIncompleteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CharacterExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CharacterAlreadyExistsException.class})
    public ResponseEntity<Object> handleAlreadyExists(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {CharacterNotFoundException.class})
    public ResponseEntity<Object> handleNotFound(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {CharacterObjectIncompleteException.class})
    public ResponseEntity<Object> handleIncomplete(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
