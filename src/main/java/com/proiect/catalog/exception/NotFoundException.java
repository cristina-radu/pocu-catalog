package com.proiect.catalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)      //used to change the response status in case of an exception from the default 500
public class NotFoundException extends BaseException {

    public NotFoundException(String message, String errorCode) {
        super(message, errorCode);
    }

    public NotFoundException(String message, Throwable cause, String errorCode) {
        super(message, cause, errorCode);
    }
}
