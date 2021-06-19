package com.jamilovf.hrms.entity.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @OneToMany(mappedBy = "cv")
    private List<CvCandidateEducation> cvCandidateEducationList;

    @OneToMany(mappedBy = "cv")
    private List<CvCandidateExperience> cvCandidateExperienceList;

    @OneToMany(mappedBy = "cv")
    private List<CvCandidateLanguage> cvCandidateLanguageList;

    @OneToMany(mappedBy = "cv")
    private List<CvCandidateTechnologyStack> cvCandidateTechnologyStackList;

    @OneToOne
    @JoinColumn(name = "cv_image_id")
    private CvImage cvImage;

    @OneToOne
    @JoinColumn(name = "social_media_details_id")
    private SocialMediaDetails socialMediaDetails;

}

