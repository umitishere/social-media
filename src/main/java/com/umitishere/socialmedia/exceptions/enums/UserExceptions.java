package com.umitishere.socialmedia.exceptions.enums;

import com.umitishere.socialmedia.exceptions.Exceptions;
import org.springframework.http.HttpStatus;

public enum UserExceptions implements Exceptions {

    EMAIL_NOT_EXIST(10000, "Email doesn't exist.", HttpStatus.BAD_REQUEST),
    INVALID_USERNAME_OR_PASSWORD(10001, "Invalid username or password.", HttpStatus.BAD_REQUEST),
    EMAIL_IS_ALREADY_TAKEN(10002, "Email is already taken.", HttpStatus.BAD_REQUEST);

    private final int value;
    private final String message;
    private final HttpStatus status;

    UserExceptions(int value, String message, HttpStatus status) {
        this.value = value;
        this.message = message;
        this.status = status;
    }

    public String getPrefix() {
        return "USER";
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
