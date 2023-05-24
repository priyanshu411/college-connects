package com.priyanshu.collegeConnects.news.api;

import com.priyanshu.collegeConnects.database.entity.News;
import com.priyanshu.collegeConnects.jwt.jwtHelper.JwtUtil;
import com.priyanshu.collegeConnects.news.dto.NewsResponseDto;
import com.priyanshu.collegeConnects.news.service.NewsService;
import com.priyanshu.collegeConnects.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Slf4j
public class NewsApi {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private NewsService service;
    @PostMapping(value="/uploadNews")
    public ApiResponse uploadNews(@RequestBody News news,@RequestHeader("Authorization") String authorization){
        String jwtToken=authorization.substring(7);
        news.setUserId(jwtUtil.extractUsername(jwtToken));
        return service.uploadNews(news);
    }

    @GetMapping(value = "/news")
    public List<NewsResponseDto> getNews(@RequestParam("date") String newsDate, @RequestHeader("Authorization") String authorization){
        String jwtToken=authorization.substring(7);
        return service.getNews(jwtUtil.extractUsername(jwtToken),newsDate);
    }

}
