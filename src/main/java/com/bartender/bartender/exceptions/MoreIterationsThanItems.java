package com.bartender.bartender.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MoreIterationsThanItems extends ResponseStatusException {
    public MoreIterationsThanItems(HttpStatus status, String reason) {
        super(status, reason);
    }
}
