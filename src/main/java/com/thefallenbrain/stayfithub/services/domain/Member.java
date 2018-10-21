package com.thefallenbrain.stayfithub.services.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member extends EndUser{

    @OneToOne
    Goal goal;

    Integer goalID;

    @OneToOne
    FitnessCenter fitnessCenter;

    @Nullable
    @OneToOne
    Trainer trainer;

    @OneToOne
    HeadTrainer headTrainer;

    @OneToOne
    Membership membership;

    Boolean isMembershipActive;

    @ManyToOne
    WorkoutPlan workoutPlan;


    @OneToMany(fetch = FetchType.EAGER)
    List<Appointment> appointments;

    String smokingStatus;

    String alcoholStatus;

    String activityStatus;

    double waistSize;
    double hipSize;
    int magicPin;

    String location;

    String aboutYourself;

    Boolean isEmailVerified = false;
    Date workoutPlanStartDate;
    Date workoutPlanEndDate;

}
