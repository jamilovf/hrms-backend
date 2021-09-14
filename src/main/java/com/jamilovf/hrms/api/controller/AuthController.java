package com.jamilovf.hrms.api.controller;

import com.jamilovf.hrms.business.abstracts.AuthService;
import com.jamilovf.hrms.core.model.request.PasswordRequestModel;
import com.jamilovf.hrms.core.utils.results.ErrorDataResult;
import com.jamilovf.hrms.dto.CandidateDto;
import com.jamilovf.hrms.dto.EmployerDto;
import com.jamilovf.hrms.dto.SystemPersonnelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/registerCandidate")
    public ResponseEntity<?> registerCandidate(HttpServletRequest request, @Valid @RequestBody CandidateDto candidateDto){
        return ResponseEntity.ok(this.authService.registerCandidate(request, candidateDto));
    }

    @PostMapping("/registerEmployer")
    public ResponseEntity<?> registerEmployer(HttpServletRequest request, @Valid @RequestBody EmployerDto employerDto) {
        return ResponseEntity.ok(this.authService.registerEmployer(request, employerDto));
    }

    @PostMapping("/registerSystemPersonnel")
    public ResponseEntity<?> registerSystemPersonnel(HttpServletRequest request, @Valid @RequestBody SystemPersonnelDto systemPersonnelDto) {
        return ResponseEntity.ok(this.authService.registerSystemPersonnel(request, systemPersonnelDto));
    }

    @GetMapping("/verifyEmailToken")
    public ResponseEntity<?> verifyEmailToken(@RequestParam String token){
            return ResponseEntity.ok(this.authService.verifyEmailToken(token));
    }

    @PostMapping("/requestPasswordReset")
    public ResponseEntity<?> requestPasswordReset(HttpServletRequest request,
                                                  @RequestBody PasswordRequestModel passwordRequestModel){

            return ResponseEntity.ok(this.authService.requestPasswordReset(request, passwordRequestModel.getEmail()));

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
