package com.thefallenbrain.stayfithub.services.domain;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
@Getter
@Setter
public class FitnessCenter implements Serializable{
    @Id
    @GeneratedValue
    Integer id;

    String name;

    String address;

    String location;
}
