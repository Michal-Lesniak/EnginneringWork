package com.example.backendengineeringwork.exceptions;

public class ArgumentCannotBeNullException extends RuntimeException{
    public ArgumentCannotBeNullException() {
    }

    public ArgumentCannotBeNullException(Throwable cause) {
        super(cause);
    }

    public ArgumentCannotBeNullException(String message) {
        super(message);
    }

    public ArgumentCannotBeNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
