package com.thefallenbrain.stayfithub.services.domain;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MembershipOption {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    Integer id;

    @Column(unique = true)
    String name;

    Integer monthly;

    Integer quaterly;

    Integer halfYearly;

    Integer yearly;

    Integer prelaunchOffer;

    public MembershipOption(String name, Integer monthly, Integer quaterly, Integer halfYearly, Integer yearly, Integer prelaunchOffer) {
        this.name = name;
        this.monthly = monthly;
        this.quaterly = quaterly;
        this.halfYearly = halfYearly;
        this.yearly = yearly;
        this.prelaunchOffer = prelaunchOffer;
    }
}
