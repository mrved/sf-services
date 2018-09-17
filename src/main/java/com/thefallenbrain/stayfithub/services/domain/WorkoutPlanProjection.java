package com.thefallenbrain.stayfithub.services.domain;

import java.util.List;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "flat", types = WorkoutPlan.class)
public interface WorkoutPlanProjection {
    Integer getId();
    String getName();
    String getDescription();
    List<MuscleGroup> getMuscleGroups();
    String getSuitableFor();
    List<Activity> getActivities();
    List<WorkoutExerciseProjection> getWorkoutExercises();
}
