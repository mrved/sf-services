package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.domain.FitnessCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FitnessCenterRepository extends JpaRepository<FitnessCenter, Integer> {
    Optional<FitnessCenter> findById(Integer id);

    void deleteById(Integer id);
}
