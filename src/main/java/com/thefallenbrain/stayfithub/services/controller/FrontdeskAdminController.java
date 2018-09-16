package com.thefallenbrain.stayfithub.services.controller;

import com.thefallenbrain.stayfithub.services.domain.FrontdeskAdmin;
import com.thefallenbrain.stayfithub.services.repository.FrontdeskAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FrontdeskAdminController {
    @Autowired
    private FrontdeskAdminRepository frontdeskAdminRepository;

    @GetMapping("/frontdeskAdmins")
    public List<FrontdeskAdmin> retrieveFrontdeskAdmins(){
        return frontdeskAdminRepository.findAll();
    }

    @GetMapping("/frontdeskAdmin/{id}")
    public FrontdeskAdmin getFrontdeskAdmin(@PathVariable Integer id){
        Optional<FrontdeskAdmin> frontdeskAdmin =  frontdeskAdminRepository.findById(id);

        if(!frontdeskAdmin.isPresent())
            throw new NullPointerException();
        else
            return frontdeskAdmin.get();

    }

    @GetMapping("/frontdeskAdminsByFitnessCenterId/{id}")
    public List<FrontdeskAdmin> findFrontdeskAdminsByFitnessCenterId(@PathVariable Integer id){
        return frontdeskAdminRepository.findFrontdeskAdminsByFitnessCenterId(id);
    }

    @Transactional
    @DeleteMapping("/frontdeskAdmin/{id}")
    public void deleteFrontdeskAdmin(@PathVariable Integer id){
        frontdeskAdminRepository.deleteById(id);
    }


    @PostMapping("/frontdeskAdmin")
    public FrontdeskAdmin createMember(@RequestBody FrontdeskAdmin frontdeskAdmin){
        return frontdeskAdminRepository.save(frontdeskAdmin);
    }

    @PutMapping("frontdeskAdmin/{id}")
    public FrontdeskAdmin updateFrontdeskAdmin(@PathVariable Integer id, @RequestBody FrontdeskAdmin frontdeskAdmin){
        Optional<FrontdeskAdmin> frontdeskAdminOptional = frontdeskAdminRepository.findById(id);
        if (!frontdeskAdminOptional.isPresent())
            throw new NullPointerException();
        frontdeskAdmin.setId(id);
        return frontdeskAdminRepository.save(frontdeskAdmin);
    }
}
