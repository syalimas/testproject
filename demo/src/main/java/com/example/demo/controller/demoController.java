package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.demoModel;
import com.example.demo.service.demoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController

@RequestMapping("/demo")
@AllArgsConstructor
public class demoController {
    private final demoService dmservice;

    @PostMapping("/create")

    public ResponseEntity<String> createDemo( @RequestBody @Valid demoModel demo){
        if(demo.getName().isEmpty() || demo.getDesignation().isEmpty()){
            return   ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Bad request on validation error\n");
        }
        dmservice.saveEmployee(demo);       
        return   ResponseEntity.status(HttpStatus.CREATED).body("HTTP Status will be CREATED (CODE 201)\n EMPLOYEE ID: "+demo.getEmpid()); 
    }

    

    
}
