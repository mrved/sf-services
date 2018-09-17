package com.thefallenbrain.stayfithub.services.repository;


import com.thefallenbrain.stayfithub.services.domain.MembershipType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipTypeRepository extends CrudRepository<MembershipType, Integer>{
}
