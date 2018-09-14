package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.controller.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    Role findByName(String name);
}
