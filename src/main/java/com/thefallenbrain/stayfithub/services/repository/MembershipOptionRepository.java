package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.domain.MembershipOption;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipOptionRepository extends CrudRepository<MembershipOption, Integer>{
}
