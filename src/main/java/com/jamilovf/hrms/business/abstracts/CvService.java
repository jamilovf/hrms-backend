package com.jamilovf.hrms.business.abstracts;

import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.dto.CvDto;

public interface CvService {
    Result add(CvDto cvDto);
}
