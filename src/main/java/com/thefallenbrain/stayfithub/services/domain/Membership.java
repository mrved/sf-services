package com.thefallenbrain.stayfithub.services.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Membership {
    @Id
    @GeneratedValue
    Integer id;

    Date startDate;

    Date endDate;


    @OneToOne
    private MembershipOption membershipOption;
}
