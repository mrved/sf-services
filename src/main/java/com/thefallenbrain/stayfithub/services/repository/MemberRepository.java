package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.domain.EndUser;
import com.thefallenbrain.stayfithub.services.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{
    List<Member> findMembersByTrainerId(Integer id);

    List<Member> findMembersByFitnessCenterId(Integer id);

    List<Member> findMembersByHeadTrainerId(Integer id);
}
