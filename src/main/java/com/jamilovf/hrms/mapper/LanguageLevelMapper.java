package com.jamilovf.hrms.mapper;

import com.jamilovf.hrms.dto.LanguageLevelDto;
import com.jamilovf.hrms.entity.concretes.LanguageLevel;

public class LanguageLevelMapper {
    public static LanguageLevelDto entityToDto(LanguageLevel languageLevel){
        return new LanguageLevelDto()
                .setId(languageLevel.getId())
                .setLevel(languageLevel.getLevel());
    }

    public static LanguageLevel dtoToEntity(LanguageLevelDto languageLevelDto){
        return new LanguageLevel()
                .setId(languageLevelDto.getId())
                .setLevel(languageLevelDto.getLevel());
    }
}
