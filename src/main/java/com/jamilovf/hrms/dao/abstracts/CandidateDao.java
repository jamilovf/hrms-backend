package com.jamilovf.hrms.dao.abstracts;

import com.jamilovf.hrms.entity.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
    Candidate getByEmail(String email);
    Candidate getByIdentityNumber(String identityNumber);
}
