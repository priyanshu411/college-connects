package com.priyanshu.collegeConnects.database.repository;

import com.priyanshu.collegeConnects.database.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface INotes extends JpaRepository<Notes,Integer> {
    Optional<Notes> findByUserId(String userId);
}
