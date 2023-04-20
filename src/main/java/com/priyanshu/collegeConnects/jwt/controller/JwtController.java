package com.priyanshu.collegeConnects.jwt.controller;

import com.priyanshu.collegeConnects.jwt.service.UserService;
import com.priyanshu.collegeConnects.database.entity.CollegeUser;
import com.priyanshu.collegeConnects.exception.UserNotFoundException;
import com.priyanshu.collegeConnects.jwt.jwtHelper.JwtUtil;
import com.priyanshu.collegeConnects.jwt.response.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping(value = "/token")
    public ResponseEntity<?> generateToken(@RequestBody CollegeUser collegeUser) throws Exception {
        System.out.println(collegeUser);
        try {
            this.authenticationManager.authenticate
                    (new UsernamePasswordAuthenticationToken(collegeUser.getEnrollmentNo(),collegeUser.getPassword()));

        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new UserNotFoundException(collegeUser.getEnrollmentNo(),"User not found");
        }catch (BadCredentialsException e){
            e.printStackTrace();
            throw new UserNotFoundException(collegeUser.getEnrollmentNo(),"User not found");
        }
        //fine area
        UserDetails userDetails=this.userService.loadUserByUsername(collegeUser.getEnrollmentNo());
        String token =this.jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

}
