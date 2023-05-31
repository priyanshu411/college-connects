package com.priyanshu.collegeConnects.subjectTopics.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Builder
@Getter
public class SubjectTopicsResponseDto {
        private String subjectName;
        private String SubjectNewsDetail;
}
