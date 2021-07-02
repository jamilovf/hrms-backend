package com.jamilovf.hrms.dto;

import com.jamilovf.hrms.entity.concretes.Language;
import com.jamilovf.hrms.entity.concretes.LanguageLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CvCandidateLanguageDto {
    private Integer id;
    private Language language;
    private LanguageLevel languageLevel;
}
