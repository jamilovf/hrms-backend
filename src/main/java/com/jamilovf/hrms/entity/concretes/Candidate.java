package com.jamilovf.hrms.entity.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "person_id")
@Table(name = "candidate")
public class Candidate extends Person{

    @NotBlank(message = "First name is mandatory")
    @NotNull(message = "First name has to be present")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @NotNull(message = "Last name has to be present")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Identity number is mandatory")
    @NotNull(message = "Identity number has to be present")
    @Column(name = "identity_number")
    private String identityNumber;

    @NotBlank(message = "Birth date is mandatory")
    @NotNull(message = "Birth date has to be present")
    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "is_verified")
    private boolean isVerified;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateLanguage> candidateLanguageList;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateSchool> candidateSchoolList;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateTechnologyStack> candidateTechnologyStackList;


    @OneToMany(mappedBy = "candidate")
    private List<Cv> cvList;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateExperience> candidateExperienceList;

}
