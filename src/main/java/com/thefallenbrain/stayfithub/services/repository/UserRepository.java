package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.controller.security.User;
import com.thefallenbrain.stayfithub.services.domain.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<EndUser, Integer> {
    User findByUsername(String username);
}
