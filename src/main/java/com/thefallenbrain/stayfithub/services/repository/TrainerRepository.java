package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.domain.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer>{

    List<Trainer> findTrainerByHeadTrainerId(Integer id);

    Optional<Trainer> findById(Integer id);

    List<Trainer> findTrainersByHeadTrainerId(Integer id);

    List<Trainer> findTrainersByFitnessCenterId(Integer id);

    void deleteById(Integer id);
}
