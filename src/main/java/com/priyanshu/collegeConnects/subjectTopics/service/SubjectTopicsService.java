package com.priyanshu.collegeConnects.subjectTopics.service;

import com.priyanshu.collegeConnects.database.entity.CollegeUser;
import com.priyanshu.collegeConnects.database.entity.News;
import com.priyanshu.collegeConnects.database.entity.SubjectTopics;
import com.priyanshu.collegeConnects.database.repository.ICollegeUser;
import com.priyanshu.collegeConnects.database.repository.ISubjectTopics;
import com.priyanshu.collegeConnects.news.dto.NewsResponseDto;
import com.priyanshu.collegeConnects.response.ApiResponse;
import com.priyanshu.collegeConnects.subjectTopics.dto.SubjectTopicsResponseDto;
import com.priyanshu.collegeConnects.utility.CommonUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SubjectTopicsService {

    @Autowired
    private ISubjectTopics subjectTopicsRepo;
    @Autowired
    private ICollegeUser collegeUserRepo;

    public ApiResponse uploadSubjectTopics(String userId, SubjectTopics subjectTopics){
        subjectTopics.setUserId(userId);
        subjectTopicsRepo.save(subjectTopics);
        return new ApiResponse(userId,"success","subject topic uploaded");
    }

    public List<SubjectTopicsResponseDto> getSubjectTopicNews(String userId, String date){
        CollegeUser collegeUser=collegeUserRepo.findById(userId).get();
        List<SubjectTopics> subjectTopicsList=subjectTopicsRepo.findAllByCourseAndSemesterAndDate
                (collegeUser.getCourse(),collegeUser.getSemester(), CommonUtility.convertToDate(date));
        List<SubjectTopicsResponseDto> subjectNewsDtoList=new ArrayList<>();
        for(int i=0;i<subjectTopicsList.size();i++){
            SubjectTopics subjectTopics=subjectTopicsList.get(i);
            SubjectTopicsResponseDto subjectTopicsDtoList =SubjectTopicsResponseDto.builder()
                    .subjectName(subjectTopics.getSubjectName())
                    .SubjectNewsDetail(subjectTopics.getSubjectNewsDetail())
                    .build();
            subjectNewsDtoList.add(subjectTopicsDtoList);
        }
        return subjectNewsDtoList;
    }
}