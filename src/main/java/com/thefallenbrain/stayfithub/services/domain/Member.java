package com.thefallenbrain.stayfithub.services.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Member extends EndUser{

    @OneToOne
    Goal goal;

    @OneToOne
    FitnessCenter fitnessCenter;

    @OneToOne
    Trainer trainer;

    @OneToOne
    HeadTrainer headTrainer;

    @OneToOne
    Membership membership;

    Boolean isMembershipActive;

    @OneToOne
    WorkoutPlan workoutPlan;

    @OneToMany
    List<Appointment> appointments;

//    @OneToMany
//    List<Query> queries;

}
