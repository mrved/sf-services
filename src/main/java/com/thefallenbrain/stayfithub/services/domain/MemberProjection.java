package com.thefallenbrain.stayfithub.services.domain;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "flat", types = Member.class)
public interface MemberProjection {
	 Integer getId();
	 Goal getGoal();

	 FitnessCenterProjection getFitnessCenter();

	 TrainerProjection getTrainer();
	 HeadTrainerProjection getHeadTrainer();

	 MembershipProjection getMembership();

	 Boolean getIsMembershipActive();

	 String getSmokingStatus();

	 String getAlcoholStatus();

	 String getActivityStatus();

	 double getWaistSize();

	 double getHipSize();

	 int getMagicPin();

	 String getLocation();

	 String getAboutYourself();

	 Boolean getIsEmailVerified();

	 Date getWorkoutPlanStartDate();

	 Date getWorkoutPlanEndDate();
}
