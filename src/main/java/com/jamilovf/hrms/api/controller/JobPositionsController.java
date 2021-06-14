package com.jamilovf.hrms.api.controller;

import com.jamilovf.hrms.business.abstracts.JobPositionService;
import com.jamilovf.hrms.core.utils.results.DataResult;
import com.jamilovf.hrms.core.utils.results.ErrorDataResult;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.entity.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobPositions")
public class JobPositionsController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobPosition jobPosition) {
        return ResponseEntity.ok(this.jobPositionService.add(jobPosition));
    }


    @PostMapping("/update")
    public ResponseEntity<?>  update(@Valid @RequestBody JobPosition jobPosition) {
        return ResponseEntity.ok(this.jobPositionService.update(jobPosition));
    }

    @PostMapping("/delete")
    public ResponseEntity<?>  delete(@Valid @RequestBody JobPosition jobPosition) {
        return ResponseEntity.ok(this.jobPositionService.delete(jobPosition));
    }

    @GetMapping("/getByPosition")
    public ResponseEntity<?>  getByPosition(@Valid @RequestParam String position) {
        return ResponseEntity.ok(this.jobPositionService.getByPosition(position));
    }

    @GetMapping("/getAll")
        public ResponseEntity<?>  getAll() {
           return ResponseEntity.ok(this.jobPositionService.getAll());
        }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){

        Map<String,String> validationErrors = new HashMap<>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors =
                new ErrorDataResult<>(validationErrors,"Validation errors");
        return errors;
    }
}
