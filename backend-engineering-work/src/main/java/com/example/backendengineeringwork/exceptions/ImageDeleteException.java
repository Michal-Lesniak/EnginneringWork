package com.example.backendengineeringwork.exceptions;

public class ImageDeleteException extends RuntimeException{
    public ImageDeleteException() {
    }

    public ImageDeleteException(Throwable cause) {
        super(cause);
    }

    public ImageDeleteException(String message) {
        super(message);
    }

    public ImageDeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
