package com.jamilovf.hrms.api.controller;

import com.jamilovf.hrms.business.abstracts.CandidateService;
import com.jamilovf.hrms.core.utils.results.DataResult;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.entity.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Candidate candidate) {
        return this.candidateService.add(candidate);
    }

    @GetMapping("/getAll")
    public DataResult<List<Candidate>> getAll() {
        return this.candidateService.getAll();
    }
}
