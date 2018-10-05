package com.thefallenbrain.stayfithub.services.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@JsonPropertyOrder(value = {"id", "name", "description", "muscleGroups", "suitableFor", "activities", "workoutExercises"})
@Proxy(lazy=false)
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

    @OneToMany
    List<WorkoutExercise> workoutExercises;
}
