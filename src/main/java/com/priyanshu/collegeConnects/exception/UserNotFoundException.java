package com.priyanshu.collegeConnects.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class UserNotFoundException extends CustomException {
    public UserNotFoundException(String id,String message){
        super(id,message);
    }

}

