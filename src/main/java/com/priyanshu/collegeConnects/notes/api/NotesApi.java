package com.priyanshu.collegeConnects.notes.api;

import com.priyanshu.collegeConnects.jwt.jwtHelper.JwtUtil;
import com.priyanshu.collegeConnects.notes.dto.NotesResponseDto;
import com.priyanshu.collegeConnects.notes.service.NotesService;
import com.priyanshu.collegeConnects.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class NotesApi {

    @Autowired
    private NotesService notesService;
   @Autowired
   private JwtUtil jwtUtil;

//   upload notes
    @PostMapping(value = "/notes/upload")
    public ApiResponse uploadNotes(@RequestParam("notes")MultipartFile file ,@RequestParam ("description") String description, @RequestParam ("subject") String subject,@RequestHeader("Authorization") String authorization) throws IOException {


        ApiResponse resp=notesService.uploadNotes(file,jwtUtil.extractUsername(authorization.substring(7)),description,subject);
       log.info("response :{}",resp);
       return resp;
    }


//    get and download notes
    @GetMapping(value="/notes")
    public void getNotes(@RequestParam("fileName") String fileName, HttpServletResponse response) throws IOException {
      InputStream resource= notesService.getNotes(fileName);
        String fileExtension = fileName.substring(fileName.lastIndexOf(".")+1) ;
        if ("png".equalsIgnoreCase(fileExtension)) {
            response.setContentType(MediaType.IMAGE_PNG_VALUE);
        } else if ("jpg".equalsIgnoreCase(fileExtension) || "jpeg".equalsIgnoreCase(fileExtension)) {
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        } else if ("pdf".equalsIgnoreCase(fileExtension)) {
            response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        } else {
            throw new IllegalArgumentException("Invalid file type: " + fileExtension);
        }
//      response.setContentType(MediaType.IMAGE_PNG_VALUE);
      response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\""); // add this line to force download
      StreamUtils.copy(resource,response.getOutputStream());
    }

//    getnotes detail
    @GetMapping(value="/notes-details")
    public List<NotesResponseDto> getNotesDetail(@RequestHeader("Authorization") String authorization){
        return notesService.getNotesDetail(jwtUtil.extractUsername(authorization.substring(7)));
    }
}
