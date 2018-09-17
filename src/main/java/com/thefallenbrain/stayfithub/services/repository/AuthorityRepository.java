package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.controller.security.Authority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
}
