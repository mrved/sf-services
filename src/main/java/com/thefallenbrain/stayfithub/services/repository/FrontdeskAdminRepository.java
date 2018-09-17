package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.domain.FrontdeskAdmin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FrontdeskAdminRepository extends CrudRepository<FrontdeskAdmin, Integer>{
    List<FrontdeskAdmin> findFrontdeskAdminsByFitnessCenterId(Integer id);
}
