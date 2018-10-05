package com.thefallenbrain.stayfithub.services.domain;


import org.springframework.data.rest.core.config.Projection;


@Projection(name = "flat", types = WorkoutExercise.class)
public interface WorkoutExerciseProjection {
    Integer getId();
//    ExerciseProjection getExercise();
    Integer getExId();
    Integer getRepititions();
    Integer getSets();
    String getDayOfWeek();
}
