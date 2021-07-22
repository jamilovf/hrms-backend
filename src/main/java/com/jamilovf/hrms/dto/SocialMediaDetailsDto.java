package com.jamilovf.hrms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SocialMediaDetailsDto {
    private Integer id;
    private String githubUrl;
    private String linkedinUrl;
}
