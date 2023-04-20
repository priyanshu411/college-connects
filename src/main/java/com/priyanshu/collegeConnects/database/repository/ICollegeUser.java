package com.priyanshu.collegeConnects.database.repository;

import com.priyanshu.collegeConnects.database.entity.CollegeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICollegeUser extends JpaRepository<CollegeUser,String> {
    Optional<CollegeUser> findByEmail(String email);
}
