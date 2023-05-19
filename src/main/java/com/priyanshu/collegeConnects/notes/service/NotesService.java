package com.priyanshu.collegeConnects.notes.service;

import com.priyanshu.collegeConnects.database.entity.CollegeUser;
import com.priyanshu.collegeConnects.database.entity.Notes;
import com.priyanshu.collegeConnects.database.repository.ICollegeUser;
import com.priyanshu.collegeConnects.database.repository.INotes;
import com.priyanshu.collegeConnects.exception.ResourceNotFoundException;
import com.priyanshu.collegeConnects.exception.UploadFailedException;
import com.priyanshu.collegeConnects.notes.dto.NotesResponseDto;
import com.priyanshu.collegeConnects.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class NotesService {


    @Autowired
    private INotes notesRepo;
    @Autowired
    private ICollegeUser collegeUserRepo;
    @Value("${project.filePath}")
    private String path;

//upload notes
    public ApiResponse uploadNotes(MultipartFile file, String userId,  String description) throws IOException {


        CollegeUser user= collegeUserRepo.findById(userId).get();
        String dateTime=LocalDateTime.now().toString().replaceAll(":",".").replaceAll("T"," at ");
        String fileName=dateTime+"_"+file.getOriginalFilename();
        String filePath=path + "/" + user.getCourse() + "/" + user.getSemester();
        log.info("file path :{}",filePath);
        String filePathWithFileName=filePath+File.separator+fileName;

//        folder create or not
        File directory = new File(filePath);
        if (!directory.exists()) {
            boolean mkdirsResult = directory.mkdirs();
            if (!mkdirsResult) {
                throw new IOException("Failed to create directories for file path: " + filePath);
            }
        }

//        upload file
        Path target = Paths.get(filePathWithFileName);
        Files.copy(file.getInputStream(), target);
        if (Files.exists(target)) {
          Notes notes=  new Notes();
                    notes.setDescription(description);
                    notes.setFileName(fileName);
                    notes.setMediaType(file.getContentType());
                    notes.setFilePath(filePath);
                    notes.setUserId(user.getEnrollmentNo());
            notesRepo.save(notes);
            return new ApiResponse(user.getEnrollmentNo(),"success",fileName+" file is uploaded"); // file upload was successful

        } else {
            throw new UploadFailedException(user.getEnrollmentNo(),"upload failed"); // file upload failed
        }
    }


//    download notes
    public InputStream getNotes(String fileName) throws FileNotFoundException {
        Notes notes=notesRepo.findByFileName(fileName);
        String path=notes.getFilePath()+ File.separator+fileName;
        InputStream file=new FileInputStream(path);
        return  file;

    }

//    get file name and description
    public List<NotesResponseDto> getNotesDetail(String enrollmentNo) {
        CollegeUser user= collegeUserRepo.findById(enrollmentNo).get();
        List<Object[]> notesList = notesRepo.findNotesByCourseAndSemester(user.getCourse(), user.getSemester());
        List<NotesResponseDto> notesResponse = new ArrayList<>();
        if (notesList.isEmpty()) {
            throw new ResourceNotFoundException(user.getCourse()+","+user.getSemester(),"Resource not found");
        } else {

            for (int i = 0; i < notesList.size(); i++) {
                Object data[] = notesList.get(i);
                NotesResponseDto notes = NotesResponseDto.builder()
                        .fileName(String.valueOf(data[0]))
                        .description(String.valueOf(data[1]))
                        .build();
                notesResponse.add(notes);
            }
        }
        return notesResponse;
    }

}
