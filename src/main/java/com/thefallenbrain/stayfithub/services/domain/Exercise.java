package com.thefallenbrain.stayfithub.services.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Exercise {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer caloriesBurn;
    private String videoLink;
    private String imageLink;
}
