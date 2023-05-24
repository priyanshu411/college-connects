package com.priyanshu.collegeConnects.news.service;

import com.priyanshu.collegeConnects.collegeUser.dto.CollegeUserSummaryDto;
import com.priyanshu.collegeConnects.database.entity.CollegeUser;
import com.priyanshu.collegeConnects.database.entity.News;
import com.priyanshu.collegeConnects.database.repository.ICollegeUser;
import com.priyanshu.collegeConnects.database.repository.INews;
import com.priyanshu.collegeConnects.news.dto.NewsResponseDto;
import com.priyanshu.collegeConnects.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class NewsService {

    @Autowired
    private INews newsRepository;
    @Autowired
    private ICollegeUser collegeUserRepository;
    public ApiResponse uploadNews(News news){
        newsRepository.save(news);
       return new ApiResponse(news.getUserId(), "Success","News uploaded successfully");
    }

    public List<NewsResponseDto> getNews(String enrollmentNo ,String date){
        CollegeUser collegeUser=collegeUserRepository.findById(enrollmentNo).get();
        List<News> newsList= newsRepository.findAllByNewsDateAndCourseAndSemester
                (convertToDate(date),collegeUser.getCourse(),collegeUser.getSemester());

        List<NewsResponseDto> newsDtoList=new ArrayList<>();
        for(int i=0;i<newsList.size();i++){
            News data=newsList.get(i);
            NewsResponseDto news=NewsResponseDto.builder()
                    .newsTittle(data.getNewsTittle())
                    .newsDetail(data.getNewsDetail())
                    .build();
            newsDtoList.add(news);
        }
        return newsDtoList;
    }

    public static Date convertToDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Return null if the parsing fails
        }
    }
}
