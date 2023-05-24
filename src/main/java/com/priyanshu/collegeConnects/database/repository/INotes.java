package com.priyanshu.collegeConnects.database.repository;

import com.priyanshu.collegeConnects.database.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INotes extends JpaRepository<Notes,Integer> {
    Notes findByFileName(String fileName);

    String QUERY_FIND_NOTES="SELECT n.file_name,n.description\n" +
            "FROM notes n INNER JOIN college_user cu ON n.user_id = cu.enrollment_no\n" +
            "WHERE cu.course =:course AND cu.semester =:semester";

    @Query(value = QUERY_FIND_NOTES,nativeQuery = true)
    List<Object[]>findNotesByCourseAndSemester(@Param("course") String course,@Param("semester") String semester);
}
