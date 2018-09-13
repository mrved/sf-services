package com.thefallenbrain.stayfithub.services.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
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
}
