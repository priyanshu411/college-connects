package com.priyanshu.collegeConnects.database.repository;

import com.priyanshu.collegeConnects.database.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface INews extends JpaRepository<News,Integer> {
    List<News> findAllByNewsDateAndCourseAndSemester(Date newsDate,String course,String semester);
}
