package com.jamilovf.hrms.business.concretes;

import com.jamilovf.hrms.business.abstracts.CvService;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.core.utils.results.SuccessResult;
import com.jamilovf.hrms.dao.abstracts.CandidateDao;
import com.jamilovf.hrms.dao.abstracts.CvDao;
import com.jamilovf.hrms.dto.CvDto;
import com.jamilovf.hrms.entity.concretes.*;
import com.jamilovf.hrms.mapper.CvMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CvManager implements CvService {

    private CvDao cvDao;
    private CandidateDao candidateDao;

    @Autowired
    public CvManager(CvDao cvDao, CandidateDao candidateDao) {
        this.cvDao = cvDao;
        this.candidateDao = candidateDao;
    }

    @Override
    public Result add(CvDto cvDto) {
        Cv cv = CvMapper.dtoToEntity(cvDto);

        Candidate candidate = this.candidateDao.getById(cvDto.getCandidateId());
        cv.setCandidate(candidate);

        cv.getCvCandidateEducationList().stream()
                .map(c -> c.setCv(cv))
                .collect(Collectors.toList());

        cv.getCvCandidateExperienceList().stream()
                .map(c -> c.setCv(cv))
                .collect(Collectors.toList());

        cv.getCvCandidateLanguageList().stream()
                .map(c -> c.setCv(cv))
                .collect(Collectors.toList());

        cv.getCvCandidateTechnologyStackList().stream()
                .map(c -> c.setCv(cv))
                .collect(Collectors.toList());

        cv.getCvImage().setCv(cv); 
        cv.getSocialMediaDetails().setCv(cv);

        this.cvDao.save(cv);
        return new SuccessResult("Cv is added");
    }
}
