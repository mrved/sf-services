package com.thefallenbrain.stayfithub.services.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String code;

    private Date startDate;

    private Date endDate;

    @OneToMany
    private List<FitnessCenter> fitnessCenters;
}
