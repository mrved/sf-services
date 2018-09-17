package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.controller.security.User;
import com.thefallenbrain.stayfithub.services.domain.EndUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<EndUser, Integer> {
    User findByUsername(String username);
}
