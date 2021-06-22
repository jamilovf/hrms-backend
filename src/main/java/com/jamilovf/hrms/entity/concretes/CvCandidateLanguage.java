package com.jamilovf.hrms.entity.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_candidate_language")
public class CvCandidateLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "candidate_id")
    @ManyToOne
    private Candidate candidate;

    @JoinColumn(name = "language_id")
    @ManyToOne
    private Language language;

    @JoinColumn(name = "cv_id")
    @ManyToOne
    private Cv cv;

    @JoinColumn(name = "language_level_id")
    @ManyToOne
    private LanguageLevel languageLevel;

}

