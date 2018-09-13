package com.thefallenbrain.stayfithub.services.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter

public class Workout {
    @Id
    @GeneratedValue()
    private Integer id;

    private Date startDate;

    private Date endDate;

    @OneToOne
    private HeadTrainer headTrainer;

    @OneToOne
    private Member member;

    @OneToMany
    private List<Exercise> exercises;

}
