package com.jamilovf.hrms.business.concretes;

import com.jamilovf.hrms.business.abstracts.SystemPersonnelService;
import com.jamilovf.hrms.dao.abstracts.SystemPersonnelDao;
import com.jamilovf.hrms.dto.EmployerDto;
import com.jamilovf.hrms.dto.SystemPersonnelDto;
import com.jamilovf.hrms.entity.concretes.SystemPersonnel;
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
import com.jamilovf.hrms.mapper.EmployerMapper;
import com.jamilovf.hrms.mapper.SystemPersonnelMapper;
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
    private SystemPersonnelDao systemPersonnelDao;
    private SystemPersonnelService systemPersonnelService;
    private EmailService emailService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AuthManager(CandidateDao candidateDao, CandidateService candidateService,
                       EmployerDao employerDao, EmployerService employerService,
                       SystemPersonnelDao systemPersonnelDao, SystemPersonnelService systemPersonnelService,
                       EmailService emailService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.candidateDao = candidateDao;
        this.candidateService = candidateService;
        this.employerDao = employerDao;
        this.employerService = employerService;
        this.systemPersonnelDao = systemPersonnelDao;
        this.systemPersonnelService = systemPersonnelService;
        this.emailService = emailService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Result registerCandidate(CandidateDto candidateDto) {
        Candidate candidate = CandidateMapper.dtoToEntity(candidateDto);
        candidate.setEmail(candidateDto.getEmail());
        candidate.setPassword(bCryptPasswordEncoder.encode(candidateDto.getPassword()));

        if(this.candidateDao.getByEmail(candidate.getEmail()) != null){
            throw new AuthServiceException(ErrorMessages.EMAIL_ALREADY_EXISTS.getErrorMessage());
        }
        if(this.candidateDao.getByIdentityNumber(candidate.getIdentityNumber()) != null){
            throw new AuthServiceException(ErrorMessages.IDENTITY_NUMBER_ALREADY_EXISTS.getErrorMessage());
        }

        this.candidateService.add(candidate);

        return new SuccessResult("Candidate registered successfully. "
                + emailService.sendEmail(candidate.getEmail()));
    }

    @Override
    public Result registerEmployer(EmployerDto employerDto) {
        Employer employer = EmployerMapper.dtoToEntity(employerDto);
        employer.setEmail(employerDto.getEmail());
        employer.setPassword(bCryptPasswordEncoder.encode(employerDto.getPassword()));

        if(this.employerDao.getByEmail(employer.getEmail()) != null){
            throw new AuthServiceException(ErrorMessages.EMAIL_ALREADY_EXISTS.getErrorMessage());
        }

        this.employerService.add(employer);

        return new SuccessResult("Employer registered successfully. "
                + emailService.sendEmail(employer.getEmail()));
    }

    @Override
    public Result registerSystemPersonnel(SystemPersonnelDto systemPersonnelDto) {
        SystemPersonnel systemPersonnel = SystemPersonnelMapper.dtoToEntity(systemPersonnelDto);
        systemPersonnel.setEmail(systemPersonnelDto.getEmail());
        systemPersonnel.setPassword(bCryptPasswordEncoder.encode(systemPersonnelDto.getPassword()));

        if(this.systemPersonnelDao.getByEmail(systemPersonnel.getEmail()) != null){
            throw new AuthServiceException(ErrorMessages.EMAIL_ALREADY_EXISTS.getErrorMessage());
        }

        this.systemPersonnelService.add(systemPersonnel);

        return new SuccessResult("System Personnel registered successfully. "
                + emailService.sendEmail(systemPersonnel.getEmail()));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
