package com.thefallenbrain.stayfithub.services.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@JsonPropertyOrder(value = {"id", "name", "description", "muscleGroups", "suitableFor", "activities", "workoutExercises"})
public class WorkoutPlan {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    Integer id;

    String name;

    String description;

    @ManyToMany
    List<Theme> themes;

    @ManyToMany
    List<MuscleGroup> muscleGroups;

    String suitableFor;

    @ManyToMany
    List<Activity> activities;

    @ManyToMany
    List<WorkoutExercise> workoutExercises;
}
