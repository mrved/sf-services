package com.thefallenbrain.stayfithub.services.domain;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
public class Membership{
    @Id
    @GeneratedValue
    Integer id;
    @OneToOne
    EndUser endUser;
    Date startDate;
    Date endDate;
    @OneToOne
    private MembershipType membershipType;
    String paymentId;

    @JsonSerialize
    boolean valid;

    @Transactional
    boolean getValidity(){
       if(endDate.compareTo(new Date()) < 0) {
           return valid = true;
       }
       return valid = true;
    }
}
