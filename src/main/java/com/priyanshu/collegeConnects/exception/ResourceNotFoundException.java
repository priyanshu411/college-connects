package com.priyanshu.collegeConnects.exception;

public class ResourceNotFoundException extends CustomException{
    public ResourceNotFoundException(String id, String message) {
        super(id, message);
    }
}
