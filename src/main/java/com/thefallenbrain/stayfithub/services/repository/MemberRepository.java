package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>{

    Optional<Member> findById(Integer id);

    void deleteById(Integer id);

    List<Member> findMembersByTrainerId(Integer id);

    List<Member> findMembersByHeadTrainerId(Integer id);

    List<Member> findMembersByFitnessCenterId(Integer id);

    Optional<Member> findByEmailAndPassword(String email, String password);

    Optional<Member> findByEmail(String email);
}
