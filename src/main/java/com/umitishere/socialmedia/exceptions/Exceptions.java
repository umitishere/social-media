package com.umitishere.socialmedia.exceptions;

import org.springframework.http.HttpStatus;

import java.util.List;

public interface Exceptions {

    String getPrefix();

    default String getCode() {
        String var10000 = this.getPrefix();
        return var10000 + "_" + this.getValue();
    }

    int getValue();

    String getMessage();

    HttpStatus getStatus();

    default RestRuntimeException instance() {
        return RestRuntimeException.of(this);
    }

    default RestRuntimeException instance(String... args) {
        return RestRuntimeException.of(this, List.of(args));
    }

}
