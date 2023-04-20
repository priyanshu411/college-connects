package com.priyanshu.collegeConnects.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class UserAlreadyPresentException extends CustomException{
    public UserAlreadyPresentException(String id,String message){
        super(id,message);
    }
}
