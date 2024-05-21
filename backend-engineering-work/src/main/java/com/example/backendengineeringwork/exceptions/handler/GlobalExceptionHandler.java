package com.example.backendengineeringwork.exceptions.handler;

import com.example.backendengineeringwork.exceptions.ArgumentCannotBeNullException;
import com.example.backendengineeringwork.exceptions.ImageDeleteException;
import com.example.backendengineeringwork.exceptions.ImageUploadException;
import com.example.backendengineeringwork.exceptions.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ImageUploadException.class)
    public ResponseEntity<String> handleImageUploadException(ImageUploadException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ImageDeleteException.class)
    public ResponseEntity<String> handleImageDeleteException(ImageDeleteException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }


    @ExceptionHandler(ArgumentCannotBeNullException.class)
    public ResponseEntity<String> handleIllegalArgumentException(ArgumentCannotBeNullException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
