package com.thefallenbrain.stayfithub.services.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class WorkoutExercise {
    @Id
    Integer id;

    @OneToOne
    Exercise exercise;

    @OneToOne
            Workout workout;
    Integer repitions;
}
