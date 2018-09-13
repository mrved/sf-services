package com.thefallenbrain.stayfithub.services.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue
    private Integer id;

    private double amount;

    private Date timestamp;

    @OneToOne
    private Membership membership;

    @OneToOne
    private Promotion promotion;

}
