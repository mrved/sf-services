package com.thefallenbrain.stayfithub.services.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Appointment {
    @Id
    Integer id;

    @OneToOne
    Member member;

    @OneToOne
    Trainer trainer;
}
