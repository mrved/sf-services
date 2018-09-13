package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.domain.MembershipOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipOptionRepository extends JpaRepository<MembershipOption, Integer>{
}
