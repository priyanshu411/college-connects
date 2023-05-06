package com.priyanshu.collegeConnects.exception;

public class UploadFailedException extends CustomException{

    public UploadFailedException(String id, String message) {
        super(id, message);
    }
}
