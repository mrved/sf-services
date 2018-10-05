package com.thefallenbrain.stayfithub.services.domain;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.DayOfWeek;

@Entity
@Getter
@Setter
public class WorkoutExercise {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    Integer id;



    Integer workoutPlanId;

    Integer repititions;

    Integer sets;

    String dayOfWeek;

    String status;
    String exerciseName;
    Integer exId;
}
