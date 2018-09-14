package com.thefallenbrain.stayfithub.services.controller.security;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
public class Role{

    @GeneratedValue
    @Id
    Integer id;

    @Column(unique = true, nullable = false)
    String name;

    @OneToMany
    List<Authority> authorities;
}
