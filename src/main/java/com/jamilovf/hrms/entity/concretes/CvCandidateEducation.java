package com.jamilovf.hrms.entity.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_candidate_education")
public class CvCandidateEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "entry_year")
    private Date entryYear;

    @Column(name = "graduate_year")
    private Date graduateYear;

    @JoinColumn(name = "candidate_id")
    @ManyToOne
    private Candidate candidate;

    @JoinColumn(name = "department_id")
    @ManyToOne
    private Department department;

    @JoinColumn(name = "school_id")
    @ManyToOne
    private School school;

    @JoinColumn(name = "cv_id")
    @ManyToOne
    private Cv cv;

}
