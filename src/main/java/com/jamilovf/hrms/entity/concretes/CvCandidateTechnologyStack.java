package com.jamilovf.hrms.entity.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Table(name = "candidate_technology_stack")
public class CvCandidateTechnologyStack {

    @Id
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "candidate_id")
    @ManyToOne
    private Candidate candidate;

    @JoinColumn(name = "technology_stack_id")
    @ManyToOne
    private TechnologyStack technologyStack;

    @JoinColumn(name = "cv_id")
    @ManyToOne
    private Cv cv;

}
