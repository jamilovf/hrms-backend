package com.jamilovf.hrms.business.concretes;

import com.jamilovf.hrms.exceptions.AuthServiceException;
import com.jamilovf.hrms.business.abstracts.AuthService;
import com.jamilovf.hrms.business.abstracts.CandidateService;
import com.jamilovf.hrms.business.abstracts.EmployerService;
import com.jamilovf.hrms.core.services.abstracts.EmailService;
import com.jamilovf.hrms.core.utils.results.ErrorMessages;
import com.jamilovf.hrms.core.utils.results.ErrorResult;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.core.utils.results.SuccessResult;
import com.jamilovf.hrms.dao.abstracts.CandidateDao;
import com.jamilovf.hrms.dao.abstracts.EmployerDao;
import com.jamilovf.hrms.dto.CandidateDto;
import com.jamilovf.hrms.entity.concretes.Candidate;
import com.jamilovf.hrms.entity.concretes.Employer;
import com.jamilovf.hrms.mapper.CandidateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {
    private CandidateDao candidateDao;
    private CandidateService candidateService;
    private EmployerDao employerDao;
    private EmployerService employerService;
    private EmailService emailService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AuthManager(CandidateDao candidateDao, CandidateService candidateService,
                       EmployerDao employerDao, EmployerService employerService,
                       EmailService emailService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.candidateDao = candidateDao;
        this.candidateService = candidateService;
        this.employerDao = employerDao;
        this.employerService = employerService;
        this.emailService = emailService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Result registerCandidate(CandidateDto candidateDto) {
        Candidate candidate = CandidateMapper.dtoToEntity(candidateDto);

        if(this.candidateDao.getByEmail(candidate.getEmail()) != null){
            throw new AuthServiceException(ErrorMessages.EMAIL_ALREADY_EXISTS.getErrorMessage());
        }
        if(this.candidateDao.getByIdentityNumber(candidate.getIdentityNumber()) != null){
            throw new AuthServiceException(ErrorMessages.IDENTITY_NUMBER_ALREADY_EXISTS.getErrorMessage());
        }
        candidate.setEmail(candidateDto.getEmail());
        candidate.setPassword(bCryptPasswordEncoder.encode(candidateDto.getPassword()));

        this.candidateService.add(candidate);

        return new SuccessResult("Candidate registered successfully. "
                + emailService.sendEmail(candidate.getEmail()));
    }

    @Override
    public Result registerEmployer(Employer employer) {
        if(this.employerDao.getByEmail(employer.getEmail()) != null){
            throw new AuthServiceException(ErrorMessages.EMAIL_ALREADY_EXISTS.getErrorMessage());
        }

        this.employerService.add(employer);

        return new SuccessResult("Employer registered successfully. "
                + emailService.sendEmail(employer.getEmail()));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
