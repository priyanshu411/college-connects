package com.priyanshu.collegeConnects.database.repository;

import com.priyanshu.collegeConnects.database.entity.SubjectTopics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ISubjectTopics extends JpaRepository<SubjectTopics,Integer> {
    List<SubjectTopics> findAllByCourseAndSemesterAndDate(String course, String semester, Date date);
}