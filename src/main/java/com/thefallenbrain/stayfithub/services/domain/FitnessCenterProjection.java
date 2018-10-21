package com.thefallenbrain.stayfithub.services.domain;

import org.springframework.data.rest.core.config.Projection;

//@Projection(name = "flat", types = FitnessCenter.class)
public interface FitnessCenterProjection {
	Integer getId();

    String getName();

    String getAddress();

    String getLocation();
}
