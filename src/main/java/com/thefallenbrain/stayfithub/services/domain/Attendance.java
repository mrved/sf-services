package com.thefallenbrain.stayfithub.services.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Getter
@Setter
public class Attendance {
    @Id
    @GeneratedValue
    private Integer id;

    @Past
    private Date timestamp;

    @OneToMany
    private List<Member> members;
}
