package com.priyanshu.collegeConnects.database.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subject_news")
@Getter
@Setter
@ToString
public class SubjectTopics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "subject_name")
    private String subjectName;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "subject_news_detail")
    private String subjectNewsDetail;
    @Column(name = "course")
    private String course;
    @Column(name = "semester")
    private String semester;
    @Column(name = "date")
    private Date date;

}