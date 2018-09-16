package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.domain.HeadTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeadTrainerRepository extends JpaRepository<HeadTrainer, Integer> {
    List<HeadTrainer> findHeadTrainersByFitnessCenterId(Integer id);
}
