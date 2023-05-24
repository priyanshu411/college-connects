package com.priyanshu.collegeConnects.database.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="news")
@Getter
@Setter
@ToString
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private int newsId;
    @Column(name="news_tittle")
    private String newsTittle;
    @Column(name="news_detail")
    private String newsDetail;
    @Column(name="news_date")
    private Date newsDate;
    @Column(name="user_id")
    private String userId;
    @Column(name="course")
    private String course;
    @Column(name="semester")
    private String semester;
}
