package com.thefallenbrain.stayfithub.services.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class FAQ {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    Integer id;
    String title;
    @Column(columnDefinition = "TEXT")
    String content;
}
