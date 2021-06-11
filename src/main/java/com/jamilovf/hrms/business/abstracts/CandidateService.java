package com.jamilovf.hrms.business.abstracts;

import com.jamilovf.hrms.core.utils.results.DataResult;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.entity.concretes.Candidate;

import java.util.List;

public interface CandidateService {
    Result add(Candidate candidate);
    DataResult<List<Candidate>> getAll();
}
