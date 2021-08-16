package com.jamilovf.hrms.business.concretes;

import com.jamilovf.hrms.business.abstracts.CvService;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.core.utils.results.SuccessResult;
import com.jamilovf.hrms.dao.abstracts.CandidateDao;
import com.jamilovf.hrms.dao.abstracts.CvDao;
import com.jamilovf.hrms.dao.abstracts.LanguageLevelDao;
import com.jamilovf.hrms.dto.CvDto;
import com.jamilovf.hrms.dto.LanguageLevelDto;
import com.jamilovf.hrms.entity.concretes.*;
import com.jamilovf.hrms.mapper.CvMapper;
import com.jamilovf.hrms.mapper.LanguageLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CvManager implements CvService {

    private CvDao cvDao;
    private CandidateDao candidateDao;
    private LanguageLevelDao languageLevelDao;

    @Autowired
    public CvManager(CvDao cvDao, CandidateDao candidateDao, LanguageLevelDao languageLevelDao) {
        this.cvDao = cvDao;
        this.candidateDao = candidateDao;
        this.languageLevelDao = languageLevelDao;
    }

    @Override
    public Result add(CvDto cvDto) {
        Cv cv = CvMapper.dtoToEntity(cvDto);

        Candidate candidate = this.candidateDao.getById(cvDto.getCandidateId());

        List<LanguageLevel> languageLevelList =
                this.languageLevelDao
                        .findByLevelIn(cvDto.getCvCandidateLanguageDtoList()
                                .stream()
                                .map(l -> l.getLanguageLevelDto().getLevel())
                                .collect(Collectors.toList()));

        List<LanguageLevelDto> languageLevelDtoList = languageLevelList.stream()
                                                    .map(l -> LanguageLevelMapper.entityToDto(l))
                                                    .collect(Collectors.toList());
        System.err.println(languageLevelDtoList);

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

      /*  languageLevelDtoList.stream()
                .map(l -> cv.getCvCandidateLanguageList().stream()
                .map(c -> c.setLanguageLevel(LanguageLevelMapper.dtoToEntity(l))));*/

        for(int i = 0; i < languageLevelDtoList.size(); i++){
            cv.getCvCandidateLanguageList().get(i)
                    .setLanguageLevel(LanguageLevelMapper
                            .dtoToEntity(languageLevelDtoList.get(i)));
        }

        cv.getCvCandidateTechnologyStackList().stream()
                .map(c -> c.setCv(cv))
                .collect(Collectors.toList());

        cv.getCvImage().setCv(cv); 
        cv.getSocialMediaDetails().setCv(cv);

        this.cvDao.save(cv);
        return new SuccessResult("Cv is added");
    }
}
