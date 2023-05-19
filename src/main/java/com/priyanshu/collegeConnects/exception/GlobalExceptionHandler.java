package com.priyanshu.collegeConnects.exception;

import com.priyanshu.collegeConnects.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse>badCredentialsException(UserNotFoundException e){
        ApiResponse response=new ApiResponse(e.getId(),"fail",e.getMessage());
        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyPresentException.class)
    public ResponseEntity<ApiResponse>userAlreadyPresentException(UserAlreadyPresentException e){
        ApiResponse response=new ApiResponse(e.getId(),"fail",e.getMessage());
        return new ResponseEntity<ApiResponse>(response, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(UploadFailedException.class)
    public ResponseEntity<ApiResponse>uploadFailed(UploadFailedException e){
        ApiResponse response=new ApiResponse(e.getId(),"fail",e.getMessage());
        return new ResponseEntity<ApiResponse>(response,HttpStatus.FAILED_DEPENDENCY);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse>ResourceNotFound(ResourceNotFoundException e){
        ApiResponse response=new ApiResponse(e.getId(),"fail",e.getMessage());
        return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
    }
}
