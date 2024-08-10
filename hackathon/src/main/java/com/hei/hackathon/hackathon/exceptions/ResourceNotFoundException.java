package com.hei.hackathon.hackathon.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super("Resource not found : " + message);
    }
}
