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
@Table(name = "technology_stack")
public class TechnologyStack {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "technology_name")
    private String technologyName;

    @OneToMany(mappedBy = "technologyStack")
    private List<CandidateTechnologyStack> candidateTechnologyStackList;

}
