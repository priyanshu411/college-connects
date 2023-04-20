package com.priyanshu.collegeConnects.jwt.service;

import com.priyanshu.collegeConnects.collegeUser.service.CollegeUserService;
import com.priyanshu.collegeConnects.database.entity.CollegeUser;
import com.priyanshu.collegeConnects.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    CollegeUserService collegeUserService;
    @Override
    public UserDetails loadUserByUsername(String enrollmentNo) throws UsernameNotFoundException {
        Optional<CollegeUser> collegeUser= collegeUserService.getUser(enrollmentNo);
        if(collegeUser.isPresent()){
            return new User(collegeUser.get().getEnrollmentNo(),collegeUser.get().getPassword(),new ArrayList<>());
        }else{
            throw new UserNotFoundException(enrollmentNo,"User not found");
        }
    }
}
