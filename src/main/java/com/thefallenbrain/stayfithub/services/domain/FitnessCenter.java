package com.thefallenbrain.stayfithub.services.domain;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class FitnessCenter implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    String name;

    String address;

    String location;
}
