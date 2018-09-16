package com.thefallenbrain.stayfithub.services.controller;

import com.thefallenbrain.stayfithub.services.domain.Member;
import com.thefallenbrain.stayfithub.services.domain.Trainer;
import com.thefallenbrain.stayfithub.services.repository.MemberRepository;
import com.thefallenbrain.stayfithub.services.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

@RestController
public class TrainerController {

    @Autowired
    private TrainerRepository trainerRepository;

    @GetMapping("/trainers")
    public List<Trainer> retrieveUsers() {
        return trainerRepository.findAll();
    }

    @GetMapping("/trainer/{id}")
    public Trainer retrieveTrainerByID(@PathVariable Integer id) {
        Optional<Trainer> trainer = trainerRepository.findById(id);
        if(!trainer.isPresent())
            throw new NullPointerException();
        else return trainer.get();
    }

    @GetMapping("/trainersByHeadTrainerId/{id}")
    public List<Trainer> retrieveTrainersByHeadTrainerID(@PathVariable Integer id) {
        return trainerRepository.findTrainersByHeadTrainerId(id);
    }


    @GetMapping("/trainersByFitnessCenterId/{id}")
    public List<Trainer> findMembersByHeadFitnessCenterId(@PathVariable Integer id){
        return trainerRepository.findTrainersByFitnessCenterId(id);
    }

    @Transactional
    @DeleteMapping("/trainer/{id}")
    public void deleteMember(@PathVariable Integer id){
        trainerRepository.deleteById(id);
    }


    @PostMapping("/trainer")
    public Trainer createMember(@RequestBody Trainer trainer){
        return trainerRepository.save(trainer);
    }

    @PutMapping("trainer/{id}")
    public Trainer updateTrainer(@PathVariable Integer id, @RequestBody Trainer trainer){
        Optional<Trainer> trainerOptional = trainerRepository.findById(id);
        if (!trainerOptional.isPresent())
            throw new NullPointerException();
        trainer.setId(id);
        return trainerRepository.save(trainer);
    }
}
