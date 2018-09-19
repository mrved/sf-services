package com.thefallenbrain.stayfithub.services.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    Integer rating;
    private String description;

    @HandleBeforeCreate
    void setDate(){
        timestamp = new Date();
    }

    private Date timestamp;

    String whatDidYouLike;

    String whatToImprove;

    String recommendation;
}
