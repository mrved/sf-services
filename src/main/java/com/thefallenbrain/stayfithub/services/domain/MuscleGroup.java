package com.thefallenbrain.stayfithub.services.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MuscleGroup {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    Integer id;

    String name;

    @ManyToOne
    Exercise exercise;
}
