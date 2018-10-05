package com.thefallenbrain.stayfithub.services.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Proxy(lazy = true)
public class Appointment {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    Integer id;

    Date date;
    String timeSlot;

    String timeAttended;

    @ManyToOne
    FitnessCenter fitnessCenter;

}
