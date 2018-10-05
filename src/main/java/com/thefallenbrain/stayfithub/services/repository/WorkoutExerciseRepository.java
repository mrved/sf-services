package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.domain.WorkoutExercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutExerciseRepository extends CrudRepository<WorkoutExercise, Integer>{

    List<WorkoutExercise> findAllByWorkoutPlanId(Integer id1);
}
