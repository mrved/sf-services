package com.thefallenbrain.stayfithub.services.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.rest.core.config.Projection;

//@Projection(name = "flat", types = Exercise.class)
public interface ExerciseProjection {
    Integer getId();
    String getName();
    List<MuscleGroup> getPartsTargeted();
}
