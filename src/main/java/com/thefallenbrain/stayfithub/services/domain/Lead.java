package com.thefallenbrain.stayfithub.services.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Lead extends EndUser{

    private Date enquiryDate;

    private String status;

    @OneToOne
    private FitnessCenter fitnessCenter;

    @OneToOne
    private Member userIfConverted;

}
