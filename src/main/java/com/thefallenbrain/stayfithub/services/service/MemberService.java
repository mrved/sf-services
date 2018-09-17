package com.thefallenbrain.stayfithub.services.service;

import com.thefallenbrain.stayfithub.services.domain.Member;
import com.thefallenbrain.stayfithub.services.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('MEMBER_READ')")
    public Iterable<Member> getAll() {
        return memberRepository.findAll();
    }

    @Transactional
    @PreAuthorize("hasAuthority('MEMBER_DELETE')")
    public void delete(Member company) {
        memberRepository.delete(company);
    }

}
