package com.priyanshu.collegeConnects.exception;


public class UserAlreadyPresentException extends CustomException{
    public UserAlreadyPresentException(String id,String message){
        super(id,message);
    }
}
