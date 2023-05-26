package com.priyanshu.collegeConnects.database.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="notes")
@Getter
@Setter
@ToString
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="user_id")
    private String userId;
    @Column(name="file_name")
    private String fileName;
    @Column(name="description")
    private String description;
    @Column (name="media_type")
    private String mediaType;
    @Column(name="file_path")
    private String filePath;
    @Column(name="subject")
    private String subject;

}
