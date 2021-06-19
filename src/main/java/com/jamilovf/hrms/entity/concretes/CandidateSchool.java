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
@Table(name = "candidate_school")
public class CandidateSchool {

    @Id
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

    @OneToMany(mappedBy = "candidateSchool")
    private List<Cv> cvList;

}