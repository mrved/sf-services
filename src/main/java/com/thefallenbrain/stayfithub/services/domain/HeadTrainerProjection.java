package com.thefallenbrain.stayfithub.services.domain;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "flat", types = HeadTrainer.class)
public interface HeadTrainerProjection {
	FitnessCenterProjection getFitnessCenter();
}
