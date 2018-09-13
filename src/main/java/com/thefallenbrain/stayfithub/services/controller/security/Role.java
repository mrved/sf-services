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
public class Role implements Serializable{

    @GeneratedValue
    @Id
            Integer id;

    String role;

    @OneToMany(fetch = FetchType.EAGER)
    List<Authority> authorities;
}
