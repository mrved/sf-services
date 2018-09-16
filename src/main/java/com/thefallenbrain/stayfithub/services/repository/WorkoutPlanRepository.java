package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.domain.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Integer>{
}
