package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.domain.ApplicationForm;
import com.thefallenbrain.stayfithub.services.domain.HubForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HubFormRepository extends JpaRepository<HubForm, Integer> {

}
