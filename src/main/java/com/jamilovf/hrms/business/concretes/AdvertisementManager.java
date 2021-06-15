package com.jamilovf.hrms.business.concretes;

import com.jamilovf.hrms.business.abstracts.AdvertisementService;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.core.utils.results.SuccessResult;
import com.jamilovf.hrms.dao.abstracts.AdvertisementDao;
import com.jamilovf.hrms.dao.abstracts.EmployerDao;
import com.jamilovf.hrms.entity.concretes.Advertisement;
import com.jamilovf.hrms.entity.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdvertisementManager implements AdvertisementService {

    private AdvertisementDao advertisementDao;
    private EmployerDao employerDao;

    @Autowired
    public AdvertisementManager(AdvertisementDao advertisementDao, EmployerDao employerDao) {
        this.advertisementDao = advertisementDao;
        this.employerDao = employerDao;
    }

    @Override
    public Result add(Advertisement advertisement) {
        Employer employer = employerDao.getById(advertisement.getEmployer().getId());
        this.advertisementDao.save(advertisement);
        return new SuccessResult("Advertisement is added by " + employer.getCompanyName());
    }
}
