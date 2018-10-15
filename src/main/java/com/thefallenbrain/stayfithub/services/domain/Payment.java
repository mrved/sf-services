package com.thefallenbrain.stayfithub.services.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Entity
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String paymentId;
    private Date startDate;
    private Date endDate;
    private String memberName;
    private Integer memberId;
    private String memberShipType;
    private double amount;
    private Date timestamp;

}
