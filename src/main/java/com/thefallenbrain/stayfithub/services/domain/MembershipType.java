package com.thefallenbrain.stayfithub.services.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MembershipType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String description;
    private Integer price;
    private Long duration;
    @OneToMany
    List<Member> members;
}
