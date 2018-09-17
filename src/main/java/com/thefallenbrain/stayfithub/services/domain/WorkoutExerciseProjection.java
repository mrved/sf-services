package com.thefallenbrain.stayfithub.services.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sun.xml.internal.ws.api.pipe.FiberContextSwitchInterceptor;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "flat", types = WorkoutExercise.class)
public interface WorkoutExerciseProjection {
    Integer getId();
    ExerciseProjection getExercise();
    Integer getRepititions();
    Integer getSets();
}
