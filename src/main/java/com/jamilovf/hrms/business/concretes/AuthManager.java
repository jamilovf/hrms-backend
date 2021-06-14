package com.jamilovf.hrms.business.concretes;

import com.jamilovf.hrms.business.abstracts.AuthService;
import com.jamilovf.hrms.business.abstracts.CandidateService;
import com.jamilovf.hrms.business.abstracts.EmployerService;
import com.jamilovf.hrms.core.services.abstracts.EmailService;
import com.jamilovf.hrms.core.utils.results.ErrorResult;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.core.utils.results.SuccessResult;
import com.jamilovf.hrms.dao.abstracts.CandidateDao;
import com.jamilovf.hrms.dao.abstracts.EmployerDao;
import com.jamilovf.hrms.entity.concretes.Candidate;
import com.jamilovf.hrms.entity.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {
    private CandidateDao candidateDao;
    private CandidateService candidateService;
    private EmployerDao employerDao;
    private EmployerService employerService;
    private EmailService emailService;

    @Autowired
    public AuthManager(CandidateDao candidateDao, CandidateService candidateService,
                       EmployerDao employerDao, EmployerService employerService, EmailService emailService) {
        this.candidateDao = candidateDao;
        this.candidateService = candidateService;
        this.employerDao = employerDao;
        this.employerService = employerService;
        this.emailService = emailService;
    }

    @Override
    public Result registerCandidate(Candidate candidate) {
        if(this.candidateDao.getByEmail(candidate.getEmail()) != null){
            return new ErrorResult("Candidate with this email already exists");
        }
        if(this.candidateDao.getByIdentityNumber(candidate.getIdentityNumber()) != null){
            return new ErrorResult("Candidate with this identity already exists");
        }
        this.candidateService.add(candidate);

        return new SuccessResult("Candidate registered successfully. "
                + emailService.sendEmail(candidate.getEmail()));
    }

    @Override
    public Result registerEmployer(Employer employer) {
        if(this.employerDao.getByEmail(employer.getEmail()) != null){
            return new ErrorResult("Employer with this email already exists");
        }
        this.employerService.add(employer);

        return new SuccessResult("Employer registered successfully. "
                + emailService.sendEmail(employer.getEmail()));
    }
}
