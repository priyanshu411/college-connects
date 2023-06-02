package com.priyanshu.collegeConnects.database.repository;

import com.priyanshu.collegeConnects.database.entity.CollegeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICollegeUser extends JpaRepository<CollegeUser,String> {
    Optional<CollegeUser> findByEmail(String email);

    String QUERY_FIND_ALUMNI_DETAIL="SELECT  c.user_name,c.email,c.contact_no,c.course\n" +
            ",ad.previous_company,ad.resume_url,ad.linkedin_user_name,ad.github_user_name ,ad.portfolio_url\n" +
            "from college_user c\n" +
            "inner join alumini a on c.enrollment_no=a.user_id\n" +
            "inner join alumini_detail ad on ad.alumini_id=a.alumini_id\n" +
            "where :userName is NULL or c.user_name=:userName";
    @Query(value = QUERY_FIND_ALUMNI_DETAIL,nativeQuery = true)
    List<Object[]> searchUserAndAlumniDetail(@Param("userName") String userName);
}
