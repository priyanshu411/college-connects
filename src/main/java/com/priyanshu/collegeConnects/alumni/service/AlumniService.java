package com.priyanshu.collegeConnects.alumni.service;

import com.priyanshu.collegeConnects.alumni.dto.AlumniDetailResponseDto;
import com.priyanshu.collegeConnects.database.entity.Alumni;
import com.priyanshu.collegeConnects.database.entity.AlumniDetail;
import com.priyanshu.collegeConnects.database.repository.IAlumni;
import com.priyanshu.collegeConnects.database.repository.IAlumniDetail;
import com.priyanshu.collegeConnects.database.repository.ICollegeUser;
import com.priyanshu.collegeConnects.exception.UserAlreadyPresentException;
import com.priyanshu.collegeConnects.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumniService {
    @Autowired
    IAlumni alumniRepo;
    @Autowired
    IAlumniDetail alumniDetailRepo;
    @Autowired
    ICollegeUser collegeUserRepo;
    public ApiResponse addAlumni(AlumniDetail alumniDetail,String enrollmentNo){
         if(alumniRepo.findByUserId(enrollmentNo).isPresent()){
             throw new UserAlreadyPresentException(enrollmentNo,"user already alumni");
         }
             Alumni alumni=new Alumni();
             alumni.setUserId(enrollmentNo);
             alumni=alumniRepo.save(alumni);
             alumniDetail.setAluminiId(alumni.getAluminiID());
                alumniDetailRepo.save(alumniDetail);
        return new ApiResponse(enrollmentNo,"success","Alumni details added");
    }

    public List<AlumniDetailResponseDto> searchAlumni(String userName){
        List<Object[]> alumniList=collegeUserRepo.searchUserAndAlumniDetail(userName);
        List<AlumniDetailResponseDto> alumniDetailResponseDto=new ArrayList<>();
        for(int i=0;i<alumniList.size();i++){
            Object[] data=alumniList.get(i);
            AlumniDetailResponseDto detail=AlumniDetailResponseDto.builder()
                    .userName(String.valueOf(data[0]))
                    .email(String.valueOf(data[1]))
                    .contactNo(String.valueOf(data[2]))
                    .course(String.valueOf(data[3]))
                    .company(String.valueOf(data[4]))
                    .resume(String.valueOf(data[5]))
                    .linkedIn(String.valueOf(data[6]))
                    .github(String.valueOf(data[7]))
                    .portfolio(String.valueOf(data[8]))
                    .build();
            alumniDetailResponseDto.add(detail);
        }
        return alumniDetailResponseDto;
    }
}
