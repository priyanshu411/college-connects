package com.priyanshu.collegeConnects.database.repository;

import com.priyanshu.collegeConnects.database.entity.Alumni;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAlumni extends JpaRepository<Alumni,Integer> {
    Optional<Alumni> findByUserId(String userId);
}
