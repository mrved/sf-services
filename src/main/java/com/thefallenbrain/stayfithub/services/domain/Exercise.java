package com.thefallenbrain.stayfithub.services.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;

@Entity
@Getter
@Setter

@JsonPropertyOrder(value = {"id", "name", "partsTargeted"})
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;

    @OneToMany
    List<MuscleGroup> partsTargeted;
}
