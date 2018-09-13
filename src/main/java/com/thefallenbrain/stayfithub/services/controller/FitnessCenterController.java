package com.thefallenbrain.stayfithub.services.controller;

import com.thefallenbrain.stayfithub.services.domain.FitnessCenter;
import com.thefallenbrain.stayfithub.services.repository.FitnessCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FitnessCenterController {
    @Autowired
    private FitnessCenterRepository fitnessCenterRepository;

    @GetMapping("/fitnessCenters")
    public List<FitnessCenter> retreiveCenters(){
        return fitnessCenterRepository.findAll();
    }

    @GetMapping("/fitnessCenter/{id}")
    public FitnessCenter retreiveCentersByID(@PathVariable Integer id){
        Optional<FitnessCenter> fitnessCenter =  fitnessCenterRepository.findById(id);
        if(!fitnessCenter.isPresent())
            throw new NullPointerException();
        else return fitnessCenter.get();
    }

    @PostMapping("/fitnessCenter")
    public FitnessCenter addCenter(@RequestBody FitnessCenter fitnessCenter){
        return fitnessCenterRepository.save(fitnessCenter);
    }

    @PutMapping("fitnessCenter/{id}")
    public FitnessCenter updateFitnessCenter(@PathVariable Integer id, @RequestBody FitnessCenter fitnessCenter){
        Optional<FitnessCenter> memberOptional = fitnessCenterRepository.findById(id);
        if (!memberOptional.isPresent())
            throw new NullPointerException();
        fitnessCenter.setId(id);
        return fitnessCenterRepository.save(fitnessCenter);
    }

    @Transactional
    @DeleteMapping("/fitnessCenter/{id}")
    public void deleteMember(@PathVariable Integer id){
        fitnessCenterRepository.deleteById(id);
    }

}
