package com.thefallenbrain.stayfithub.services.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private Integer duration;

    @OneToOne
    private HeadTrainer headTrainer;

    @OneToOne
    private Member member;

    @OneToOne
    private WorkoutPlan workoutPlan;

}
