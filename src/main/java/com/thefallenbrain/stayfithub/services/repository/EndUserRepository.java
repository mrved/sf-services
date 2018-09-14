package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.domain.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EndUserRepository extends JpaRepository<EndUser, Integer>{
    EndUser findByEmailAndPassword(String email, String password);
}
