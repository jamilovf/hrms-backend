package com.jamilovf.hrms.business.abstracts;

import com.jamilovf.hrms.core.utils.results.DataResult;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.entity.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    Result add(JobPosition jobPosition);
    Result update(JobPosition jobPosition);
    Result delete(JobPosition jobPosition);
    DataResult<JobPosition> getByPosition(String position);
    DataResult<List<JobPosition>> getAll();
}
