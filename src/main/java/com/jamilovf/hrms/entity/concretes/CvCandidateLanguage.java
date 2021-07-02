package com.jamilovf.hrms.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Accessors(chain = true)
@Table(name = "cv_candidate_language")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class CvCandidateLanguage {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "language_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Language language;

    @JoinColumn(name = "cv_id")
    @ManyToOne
    private Cv cv;

    @JoinColumn(name = "language_level_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private LanguageLevel languageLevel;

}

