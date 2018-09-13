package com.thefallenbrain.stayfithub.services.controller;

import com.thefallenbrain.stayfithub.services.domain.HeadTrainer;
import com.thefallenbrain.stayfithub.services.repository.HeadTrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HeadTrainerController {

    @Autowired
    private HeadTrainerRepository headTrainerRepository;

    @GetMapping("/headTrainers")
    public List<HeadTrainer> retrieveHeadTrainers(){
        return headTrainerRepository.findAll();
    }

    @GetMapping("/headTrainer/{id}")
    public HeadTrainer getHeadTrainer(@PathVariable Integer id){
        Optional<HeadTrainer> headTrainer =  headTrainerRepository.findById(id);

        if(!headTrainer.isPresent())
            throw new NullPointerException();
        else
            return headTrainer.get();

    }

    @GetMapping("/headTrainersByFitnessCenterId/{id}")
    public List<HeadTrainer> findHeadTrainersByHeadFitnessCenterId(@PathVariable Integer id){
        return headTrainerRepository.findHeadTrainersByFitnessCenterId(id);
    }

    @Transactional
    @DeleteMapping("/headTrainer/{id}")
    public void deleteHeadTrainer(@PathVariable Integer id){
        headTrainerRepository.deleteById(id);
    }


    @PostMapping("/headTrainer")
    public HeadTrainer createMember(@RequestBody HeadTrainer headTrainer){
        return headTrainerRepository.save(headTrainer);
    }

    @PutMapping("headTrainer/{id}")
    public HeadTrainer updateTrainer(@PathVariable Integer id, @RequestBody HeadTrainer headTrainer){
        Optional<HeadTrainer> headTrainerOptional = headTrainerRepository.findById(id);
        if (!headTrainerOptional.isPresent())
            throw new NullPointerException();
        headTrainer.setId(id);
        return headTrainerRepository.save(headTrainer);
    }
}
