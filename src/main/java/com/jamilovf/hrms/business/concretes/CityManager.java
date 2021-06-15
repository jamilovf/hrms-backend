package com.jamilovf.hrms.business.concretes;

import com.jamilovf.hrms.business.abstracts.CityService;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.core.utils.results.SuccessResult;
import com.jamilovf.hrms.dao.abstracts.CityDao;
import com.jamilovf.hrms.entity.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public Result add(City city) {
        this.cityDao.save(city);
        return new SuccessResult("City is added: " + city.getName());
    }
}
