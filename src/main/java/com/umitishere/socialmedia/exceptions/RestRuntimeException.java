package com.umitishere.socialmedia.exceptions;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;

import java.text.MessageFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestRuntimeException extends RuntimeException {

    private final Exceptions exceptions;
    private final ZonedDateTime timestamp;
    private final String errorCode;
    private final HttpStatus httpStatus;
    private final Map<String, Object> additionalParameters = new HashMap();
    private String fieldName;
    private List<String> args = new ArrayList();

    public static RestRuntimeException of(Exceptions exceptions) {
        return new RestRuntimeException(exceptions, (String)null, (List)null);
    }

    public static RestRuntimeException of(Exceptions exceptions, String fieldName) {
        return new RestRuntimeException(exceptions, fieldName, (List)null);
    }

    public static RestRuntimeException of(Exceptions exceptions, List<String> args) {
        return new RestRuntimeException(exceptions, (String)null, args);
    }

    private RestRuntimeException(Exceptions exceptions, String fieldName, List<String> arguments) {
        super(CollectionUtils.isEmpty(arguments) ? exceptions.getMessage() : MessageFormat.format(exceptions.getMessage(), arguments));

        this.exceptions = exceptions;
        this.timestamp = ZonedDateTime.now();
        this.errorCode = String.valueOf(exceptions.getCode());
        this.httpStatus = exceptions.getStatus();

        if (StringUtils.isNotEmpty(fieldName)) {
            this.fieldName = fieldName;
        }

        if (!CollectionUtils.isEmpty(arguments)) {
            this.args = arguments;
        }
    }

    public List<String> getArguments() {
        return this.args;
    }

    private void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Exceptions getExceptions() {
        return this.exceptions;
    }

    public ZonedDateTime getTimestamp() {
        return this.timestamp;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public Map<String, Object> getAdditionalParameters() {
        return this.additionalParameters;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public List<String> getArgs() {
        return this.args;
    }
}
