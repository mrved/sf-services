package com.thefallenbrain.stayfithub.services.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
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
