package com.thefallenbrain.stayfithub.services.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Getter
@Setter
public class HeadTrainer extends EndUser{

    @OneToOne
    FitnessCenter fitnessCenter;

    @OneToMany
    List<Trainer> trainers;

}
