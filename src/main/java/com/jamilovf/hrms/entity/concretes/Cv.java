package com.jamilovf.hrms.entity.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv")
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

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

    @OneToOne
    @JoinColumn(name = "cv_image_id")
    private CvImage cvImage;

    @OneToOne
    @JoinColumn(name = "social_media_details_id")
    private SocialMediaDetails socialMediaDetails;

}

