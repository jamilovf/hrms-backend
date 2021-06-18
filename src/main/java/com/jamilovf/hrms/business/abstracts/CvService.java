package com.jamilovf.hrms.business.abstracts;

import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.entity.concretes.Cv;

public interface CvService {
    Result add(Cv cv);
}
