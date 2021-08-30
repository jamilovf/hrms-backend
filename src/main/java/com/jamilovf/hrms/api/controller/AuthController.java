package com.jamilovf.hrms.api.controller;

import com.jamilovf.hrms.business.abstracts.AuthService;
import com.jamilovf.hrms.core.utils.results.ErrorDataResult;
import com.jamilovf.hrms.core.utils.results.Result;
import com.jamilovf.hrms.dto.CandidateDto;
import com.jamilovf.hrms.dto.EmployerDto;
import com.jamilovf.hrms.entity.concretes.Candidate;
import com.jamilovf.hrms.entity.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/registerCandidate")
    public ResponseEntity<?> registerCandidate(@Valid @RequestBody CandidateDto candidateDto){
        return ResponseEntity.ok(this.authService.registerCandidate(candidateDto));
    }

    @PostMapping("/registerEmployer")
    public ResponseEntity<?>  registerEmployer(@Valid @RequestBody EmployerDto employerDto) {
        return ResponseEntity.ok(this.authService.registerEmployer(employerDto));
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
