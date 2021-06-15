package com.jamilovf.hrms.business.concretes;

import com.jamilovf.hrms.business.abstracts.AdvertisementService;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.core.utils.results.SuccessResult;
import com.jamilovf.hrms.dao.abstracts.AdvertisementDao;
import com.jamilovf.hrms.entity.concretes.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementManager implements AdvertisementService {

    private AdvertisementDao advertisementDao;

    @Autowired
    public AdvertisementManager(AdvertisementDao advertisementDao) {
        this.advertisementDao = advertisementDao;
    }

    @Override
    public Result add(Advertisement advertisement) {
        this.advertisementDao.save(advertisement);
        return new SuccessResult("Advertisement is added by " + advertisement.getEmployer().getCompanyName());
    }
}
