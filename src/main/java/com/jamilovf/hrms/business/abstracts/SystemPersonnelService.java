package com.jamilovf.hrms.business.abstracts;

import com.jamilovf.hrms.core.utils.results.DataResult;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.entity.concretes.SystemPersonnel;

import java.util.List;

public interface SystemPersonnelService {
    Result add(SystemPersonnel systemPersonnel);
    DataResult<List<SystemPersonnel>> getAll();
}
