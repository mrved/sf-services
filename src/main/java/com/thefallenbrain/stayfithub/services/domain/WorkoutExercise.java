package com.thefallenbrain.stayfithub.services.domain;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@JsonPropertyOrder(value = {"id", "exercise", "repititions", "sets"})
public class WorkoutExercise {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    Integer id;

    @OneToOne
    Exercise exercise;

    @OneToOne
    Workout workout;

    Integer repititions;

    Integer sets;
}
