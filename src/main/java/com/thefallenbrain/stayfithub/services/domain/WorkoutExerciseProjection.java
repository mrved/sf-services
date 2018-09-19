package com.thefallenbrain.stayfithub.services.domain;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "flat", types = WorkoutExercise.class)
public interface WorkoutExerciseProjection {
    Integer getId();
    ExerciseProjection getExercise();
    Integer getRepititions();
    Integer getSets();
    String getDayOfWeek();
}
