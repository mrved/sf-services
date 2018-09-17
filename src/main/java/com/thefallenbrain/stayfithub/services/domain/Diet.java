package com.thefallenbrain.stayfithub.services.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Diet {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    Integer id;

    @OneToMany
    List<Meal> meals;
}
