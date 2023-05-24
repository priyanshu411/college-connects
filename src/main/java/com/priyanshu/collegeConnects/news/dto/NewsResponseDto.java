package com.priyanshu.collegeConnects.news.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NewsResponseDto {
    private String newsTittle;
    private String newsDetail;
}
