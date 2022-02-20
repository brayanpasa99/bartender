package com.bartender.bartender.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class GlassArrayNotFoundException extends ResponseStatusException{
    public GlassArrayNotFoundException(HttpStatus status, String reason){
        super(status, reason);
    }
}
