package com.thefallenbrain.stayfithub.services.domain;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

//@Projection(name = "flat", types = Trainer.class)
public interface TrainerProjection {
	Date getDoj();

	FitnessCenterProjection getFitnessCenter();

	Integer getId();

	String getName();

	String getEmail();

	String getPassword();

	String getGender();

	String getDesignation();

	String getPhone();

	Date getDob();

	String getProfilePicture();

	Double getHeight();

	Double getWeight();

	Double getBmi();

	String getUsername();

	boolean isAccountExpired();

	boolean isAccountLocked();

	boolean isCredentialsExpired();

	boolean isEnabled();


	String getMasterPassword();
}
