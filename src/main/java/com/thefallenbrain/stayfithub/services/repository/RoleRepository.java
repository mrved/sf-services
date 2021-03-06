package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.controller.security.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{
    Role findByName(String name);
}
