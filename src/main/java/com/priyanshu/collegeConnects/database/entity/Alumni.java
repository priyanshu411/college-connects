package com.priyanshu.collegeConnects.database.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name="alumini")
@Getter
@Setter
@ToString
public class Alumni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumini_id")
    private  int aluminiID;
    @Column(name="user_id")
    private String userId;
}
