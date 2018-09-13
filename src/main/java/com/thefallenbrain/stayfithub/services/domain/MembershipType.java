package com.thefallenbrain.stayfithub.services.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MembershipType {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    private double price;

    private Long duration;

    @OneToMany
    List<Member> members;
}
