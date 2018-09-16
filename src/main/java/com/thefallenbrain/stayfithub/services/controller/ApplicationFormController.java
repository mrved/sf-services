package com.thefallenbrain.stayfithub.services.controller;

import java.util.List;
import com.thefallenbrain.stayfithub.services.domain.ApplicationForm;
import com.thefallenbrain.stayfithub.services.repository.ApplicationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
@CrossOrigin
public class ApplicationFormController {
    @Autowired
    ApplicationFormRepository applicationFormRepository;
    @PostMapping(value = "/application", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    HttpStatus createForm(@RequestBody ApplicationForm applicationForm){
        System.out.println(applicationForm);
       applicationFormRepository.save(applicationForm);
       return HttpStatus.OK;
    }

    @GetMapping("/application")
    List<ApplicationForm> showAll(){
        return applicationFormRepository.findAll();
    }
}
