package com.priyanshu.collegeConnects.collegeUser.service;

import com.priyanshu.collegeConnects.database.entity.CollegeUser;
import com.priyanshu.collegeConnects.database.repository.ICollegeUser;
import com.priyanshu.collegeConnects.exception.UserAlreadyPresentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CollegeUserService {
    @Autowired
    private ICollegeUser repository;


    public CollegeUser createCollegeUser(CollegeUser user){
        if(repository.findById(user.getEnrollmentNo()).isPresent() ||repository.findByEmail(user.getEmail()).isPresent()){
            throw new UserAlreadyPresentException(user.getEnrollmentNo(),"User already present with this enrollment No or email");
        }
        repository.save(user);
        return user;
    }
    public Optional<CollegeUser> getUser(String enrollmentNo){
        Optional<CollegeUser> user=repository.findById(enrollmentNo);
        return user;

    }
}
