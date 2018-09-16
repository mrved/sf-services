package com.thefallenbrain.stayfithub.services.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Feedback {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    private Date timestamp;

    @OneToOne
    private Member givenBy;

    @OneToOne
    private FitnessCenter fitnessCenter;
}
