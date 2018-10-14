package com.thefallenbrain.stayfithub.services.domain;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;
import java.util.List;

@Projection(name = "flat", types = Membership.class)
public interface MembershipProjection {

	 Integer getId();

	 EndUser getEndUser();
	 Date getStartDate();

	 Date getEndDate();

	 MembershipType getMembershipType();

	 String getPaymentId();

	 boolean isValid();
}
