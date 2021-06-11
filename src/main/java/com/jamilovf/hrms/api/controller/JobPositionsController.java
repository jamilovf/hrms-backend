package com.jamilovf.hrms.api.controller;

import com.jamilovf.hrms.business.abstracts.JobPositionService;
import com.jamilovf.hrms.core.utils.results.DataResult;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.entity.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPositions")
public class JobPositionsController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosition jobPosition) {
        return this.jobPositionService.add(jobPosition);
    }


    @PostMapping("/update")
    public Result update(@RequestBody JobPosition jobPosition) {
        return this.jobPositionService.update(jobPosition);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobPosition jobPosition) {
        return this.jobPositionService.delete(jobPosition);
    }

    @GetMapping("/getByPosition")
    public DataResult<JobPosition> getByPosition(@RequestParam String position) {
        return this.jobPositionService.getByPosition(position);
    }

    @GetMapping("/getAll")
        public DataResult<List<JobPosition>> getAll() {
           return this.jobPositionService.getAll();
        }
}
