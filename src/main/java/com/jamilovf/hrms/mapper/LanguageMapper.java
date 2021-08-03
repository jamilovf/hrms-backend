package com.jamilovf.hrms.mapper;


import com.jamilovf.hrms.dto.LanguageDto;
import com.jamilovf.hrms.entity.concretes.Language;

public class LanguageMapper {
    public static LanguageDto entityToDto(Language language){
        return new LanguageDto()
                .setId(language.getId())
                .setLanguage(language.getLanguage());
    }

    public static Language dtoToEntity(LanguageDto languageDto){
        return new Language()
                .setId(languageDto.getId())
                .setLanguage(languageDto.getLanguage());
    }
}
