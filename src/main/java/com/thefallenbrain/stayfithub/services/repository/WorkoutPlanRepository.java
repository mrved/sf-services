package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.domain.WorkoutExercise;
import com.thefallenbrain.stayfithub.services.domain.WorkoutPlan;
import com.thefallenbrain.stayfithub.services.domain.WorkoutPlanProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(excerptProjection = WorkoutPlanProjection.class)
public interface WorkoutPlanRepository extends CrudRepository<WorkoutPlan, Integer> {
}
