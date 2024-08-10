package com.hei.hackathon.hackathon.exceptions;

public class ResourcesDuplicatedException extends RuntimeException {
    public ResourcesDuplicatedException(String message) {
        super("Resource duplicate : " + message);
    }
}
