package com.priyanshu.collegeConnects.database.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="alumini_detail")
@Getter
@Setter
@ToString
public class AlumniDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="alumini_id")
    private int aluminiId;
    @Column(name="previous_company")
    private String company;
    @Column(name="resume_url")
    private String resumeUrl;
    @Column(name="linkedin_user_name")
    private String linkedinUserName;
    @Column(name="github_user_name")
    private String githubUserName;
    @Column(name="portfolio_url")
    private String portfolioUrl;

}
