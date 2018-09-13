package com.thefallenbrain.stayfithub.services.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
public class Attendance {
    @Id
    @GeneratedValue
    private Integer id;

    @Past
    private Date timestamp;

    @OneToMany
    private List<Member> members;
}
