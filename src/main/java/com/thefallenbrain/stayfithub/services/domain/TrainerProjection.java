package com.thefallenbrain.stayfithub.services.domain;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "flat", types = Trainer.class)
public interface TrainerProjection {
	Date getDoj();
	FitnessCenterProjection getFitnessCenter();
}
