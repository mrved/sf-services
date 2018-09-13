package com.thefallenbrain.stayfithub.services.repository;


import com.thefallenbrain.stayfithub.services.domain.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipTypeRepository extends JpaRepository<MembershipType, Integer>{
}
