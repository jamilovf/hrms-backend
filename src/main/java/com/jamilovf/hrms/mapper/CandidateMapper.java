package com.jamilovf.hrms.mapper;

import com.jamilovf.hrms.dto.CandidateDto;
import com.jamilovf.hrms.entity.concretes.Candidate;


public class CandidateMapper {
    public static CandidateDto entityToDto(Candidate candidate){
        return new CandidateDto()
                .setEmail(candidate.getEmail())
                .setPassword(candidate.getPassword())
                .setFirstName(candidate.getFirstName())
                .setLastName(candidate.getLastName())
                .setBirthDate(candidate.getBirthDate())
                .setIdentityNumber(candidate.getIdentityNumber());

    }

    public static Candidate dtoToEntity(CandidateDto candidateDto){
        Candidate candidate = new Candidate();
        candidate
                .setEmail(candidateDto.getEmail())
                .setPassword(candidate.getPassword());
        candidate
                .setFirstName(candidateDto.getFirstName())
                .setLastName(candidateDto.getLastName())
                .setBirthDate(candidateDto.getBirthDate())
                .setIdentityNumber(candidateDto.getIdentityNumber());

        return candidate;
    }
}
