package com.thefallenbrain.stayfithub.services.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Membership {
    @Id
    @GeneratedValue
    Integer id;

    Date startDate;

    Date endDate;

    @OneToOne
    private MembershipType membershipType;
}
