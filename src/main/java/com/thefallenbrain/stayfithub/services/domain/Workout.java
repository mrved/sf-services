package com.thefallenbrain.stayfithub.services.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter

public class Workout {
    @Id
    @GeneratedValue()
    private Integer id;

    private Integer duration;

    @OneToOne
    private HeadTrainer headTrainer;

    @OneToOne
    private Member member;

    @OneToMany
    private List<WorkoutExercise> workoutExercises;

}
