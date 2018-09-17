package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.domain.ApplicationForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationFormRepository extends CrudRepository<ApplicationForm, Integer> {
}
