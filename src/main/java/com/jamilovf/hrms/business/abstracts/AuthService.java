package com.jamilovf.hrms.business.abstracts;

import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.dto.CandidateDto;
import com.jamilovf.hrms.dto.EmployerDto;
import com.jamilovf.hrms.dto.SystemPersonnelDto;
import com.jamilovf.hrms.entity.concretes.Candidate;
import com.jamilovf.hrms.entity.concretes.Employer;
import com.jamilovf.hrms.entity.concretes.Person;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;

public interface AuthService extends UserDetailsService {
    Result registerCandidate(HttpServletRequest request, CandidateDto candidateDto);
    Result registerEmployer(HttpServletRequest request, EmployerDto employerDto);
    Result registerSystemPersonnel(HttpServletRequest request, SystemPersonnelDto systemPersonnelDto);
    Person getPerson(String email);
    boolean verifyEmailToken(String token);
    boolean requestPasswordReset(HttpServletRequest request, String email);
}
