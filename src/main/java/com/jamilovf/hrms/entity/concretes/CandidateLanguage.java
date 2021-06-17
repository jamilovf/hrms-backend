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
@Table(name = "candidate_language")
public class CandidateLanguage {

    @Id
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "candidate_id")
    @ManyToOne
    private Candidate candidate;

    @JoinColumn(name = "language_id")
    @ManyToOne
    private Language language;

    @OneToMany(mappedBy = "candidateLanguageId")
    private List<Cv> cvList;

}

