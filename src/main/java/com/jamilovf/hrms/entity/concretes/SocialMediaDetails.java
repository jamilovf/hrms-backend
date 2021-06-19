package com.jamilovf.hrms.entity.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "social_media_details")
public class SocialMediaDetails {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "github_url")
    private String githubUrl;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    @OneToOne(mappedBy = "socialMediaDetails")
    private Cv cv;

}
