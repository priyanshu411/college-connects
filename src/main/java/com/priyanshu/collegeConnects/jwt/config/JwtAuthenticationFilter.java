package com.priyanshu.collegeConnects.jwt.config;

import com.priyanshu.collegeConnects.auth.services.UserService;
import com.priyanshu.collegeConnects.jwt.jwtHelper.JwtUtil;
import com.priyanshu.collegeConnects.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService userService;
    @Override
    protected void doFilterInternal
            (HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String tokenFromHeader=request.getHeader("Authorization");
        String userName=null;
        String jwtToken=null;
        if(tokenFromHeader!=null && tokenFromHeader.startsWith(Constants.BEARER)){
            jwtToken=tokenFromHeader.substring(7);
            try{
                userName=jwtUtil.extractUsername(jwtToken);

            }catch(Exception e){
                e.printStackTrace();

            }
           UserDetails userDetails= userService.loadUserByUsername(userName);
            //security
            if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null){

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
                        new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }else{
                System.out.println("token is not validated");
            }
        }
        filterChain.doFilter(request,response);
    }
}
