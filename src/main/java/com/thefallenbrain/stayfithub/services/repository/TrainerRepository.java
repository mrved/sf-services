package com.thefallenbrain.stayfithub.services.repository;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thefallenbrain.stayfithub.services.domain.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//@RepositoryRestResource(exported = false)
public interface TrainerRepository extends JpaRepository<Trainer, Integer>{
    List<Trainer> findTrainersByHeadTrainerId(Integer id);

    List<Trainer> findTrainersByFitnessCenterId(Integer id);
}
