package com.thefallenbrain.stayfithub.services.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Getter
@Setter
public class Appointment {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    Integer id;

    Date startDate;

    Integer duration;

    @OneToOne
    Member member;

    @OneToOne
    Trainer trainer;
}
