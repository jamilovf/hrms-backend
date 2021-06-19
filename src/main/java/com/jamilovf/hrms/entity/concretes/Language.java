package com.jamilovf.hrms.entity.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "language")
public class Language {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "language")
    private String language;

    @Column(name = "level")
    private int level;

    @OneToMany(mappedBy = "language")
    private List<CvCandidateLanguage> cvCandidateLanguageList;

}
