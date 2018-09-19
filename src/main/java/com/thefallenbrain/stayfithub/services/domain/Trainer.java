package com.thefallenbrain.stayfithub.services.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Trainer extends EndUser {

    private Date doj;

    @OneToMany
    private List<Member> members;

    @OneToOne
    private HeadTrainer headTrainer;

    @OneToOne
    private FitnessCenter fitnessCenter;

}
