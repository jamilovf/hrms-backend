package com.jamilovf.hrms.business.abstracts;

import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.entity.concretes.City;

public interface CityService {
    Result add(City city);
}
