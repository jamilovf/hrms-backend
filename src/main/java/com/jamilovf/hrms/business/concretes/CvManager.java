package com.jamilovf.hrms.business.concretes;

import com.jamilovf.hrms.business.abstracts.CvService;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.core.utils.results.SuccessResult;
import com.jamilovf.hrms.dao.abstracts.CvDao;
import com.jamilovf.hrms.entity.concretes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CvManager implements CvService {

    private CvDao cvDao;

    @Autowired
    public CvManager(CvDao cvDao) {
        this.cvDao = cvDao;
    }

    @Override
    public Result add(Cv cv) {
        CvCandidateEducation cvCandidateEducation = new CvCandidateEducation();
        CvCandidateExperience cvCandidateExperience = new CvCandidateExperience();
        CvCandidateLanguage cvCandidateLanguage = new CvCandidateLanguage();
        CvCandidateTechnologyStack cvCandidateTechnologyStack = new CvCandidateTechnologyStack();
        CvImage cvImage = new CvImage();
        SocialMediaDetails socialMediaDetails = new SocialMediaDetails();

        cvCandidateEducation.setCv(cv);
        cvCandidateExperience.setCv(cv);
        cvCandidateLanguage.setCv(cv);
        cvCandidateTechnologyStack.setCv(cv);
        cvImage.setCv(cv);
        socialMediaDetails.setCv(cv);

        this.cvDao.save(cv);
        return new SuccessResult("Cv is added");
    }
}
