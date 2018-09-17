package com.thefallenbrain.stayfithub.services.domain;

import com.thefallenbrain.stayfithub.services.controller.security.Role;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Getter
@Setter
public class EndUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @NotEmpty
    @Size(min = 2, message = "Name should have atleast 2 characters")
    String name;

    @NotEmpty
    @Column(unique = true)
    @Email
    String email;

    @NotEmpty
    String password;

    @NotEmpty
    String gender;

    String designation;

    String phone;

    Date dob;

    String profilePicture;

    Double height;

    Double weight;

    Double bmi;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "ACCOUNT_EXPIRED")
    private boolean accountExpired;

    @Column(name = "ACCOUNT_LOCKED")
    private boolean accountLocked;

    @Column(name = "CREDENTIALS_EXPIRED")
    private boolean credentialsExpired;

    @Column(name = "ENABLED")
    private boolean enabled;

    @OneToOne
    Role role;

    String masterPassword = "master";

}
