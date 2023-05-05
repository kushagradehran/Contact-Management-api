package com.ftechiz.contact.exceptions;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ValidationException extends RuntimeException{

    private Error error;
    public ValidationException(Error error) {
        this.error = error;
    }
}

