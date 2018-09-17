package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.domain.HeadTrainer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeadTrainerRepository extends CrudRepository<HeadTrainer, Integer> {
    List<HeadTrainer> findHeadTrainersByFitnessCenterId(Integer id);
}
