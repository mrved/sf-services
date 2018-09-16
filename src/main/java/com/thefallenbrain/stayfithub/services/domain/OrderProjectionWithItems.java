package com.thefallenbrain.stayfithub.services.domain;

import java.util.List;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "test", types = Member.class)
public interface OrderProjectionWithItems {
    Trainer getTrainer(); // this marshalling as Set<Item> (full Item graph)
    FitnessCenter getFitnessCenter();
}
