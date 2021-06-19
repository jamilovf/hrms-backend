package com.jamilovf.hrms.entity.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidate_experience")
public class CvCandidateExperience {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "entry_year")
    private Date entryYear;

    @Column(name = "leaving_year")
    private Date leavingYear;

    @JoinColumn(name = "cv_id")
    @ManyToOne
    private Cv cv;

    @JoinColumn(name = "candidate_id")
    @ManyToOne
    private Candidate candidate;

    @JoinColumn(name = "company_id")
    @ManyToOne
    private ExperienceCompany company;

    @JoinColumn(name = "position_id")
    @ManyToOne
    private ExperiencePosition position;

}

