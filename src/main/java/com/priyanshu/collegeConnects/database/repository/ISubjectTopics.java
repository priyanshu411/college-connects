package com.priyanshu.collegeConnects.database.repository;

import com.priyanshu.collegeConnects.database.entity.SubjectTopics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubjectTopics extends JpaRepository<SubjectTopics,Integer> {
}