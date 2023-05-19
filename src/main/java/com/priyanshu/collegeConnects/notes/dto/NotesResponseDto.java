package com.priyanshu.collegeConnects.notes.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NotesResponseDto {
    private String fileName;
    private String description;
}
