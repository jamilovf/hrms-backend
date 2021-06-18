package com.jamilovf.hrms.api.controller;

import com.jamilovf.hrms.business.abstracts.CvService;
import com.jamilovf.hrms.entity.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cv")
public class CvController {

    private CvService cvService;

    @Autowired
    public CvController(CvService cvService) {
        this.cvService = cvService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Cv cv){
        return ResponseEntity.ok(this.cvService.add(cv));
    }
}
