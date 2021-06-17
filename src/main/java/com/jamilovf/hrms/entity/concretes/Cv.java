package com.jamilovf.hrms.entity.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv")
public class Cv {

    @Id
    @Column(name = "id")
    private Integer id;


    @Column(name = "cover_letter")
    private String coverLetter;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "candidate_experience_id")
    private CandidateExperience candidateExperience;

    @ManyToOne
    @JoinColumn(name = "candidate_language_id")
    private CandidateLanguage candidateLanguage;

    @ManyToOne
    @JoinColumn(name = "candidate_school_id")
    private CandidateSchool candidateSchool;

    @ManyToOne
    @JoinColumn(name = "candidate_technology_stack_id")
    private CandidateTechnologyStack candidateTechnologyStack;

    @ManyToOne
    @JoinColumn(name = "cv_image_id")
    private CvImage cvImage;

    @ManyToOne
    @JoinColumn(name = "social_media_details_id")
    private SocialMediaDetails socialMediaDetails;

}

