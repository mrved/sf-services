package com.thefallenbrain.stayfithub.services.controller;

import com.thefallenbrain.stayfithub.services.domain.Member;
import com.thefallenbrain.stayfithub.services.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MemberShipController {

    @Autowired
    MemberRepository memberRepository;

    @PutMapping("/member/enableMembership/{id}")
    HttpStatus enableMembership(@PathVariable Integer id){
        Optional<Member> memberOptional = memberRepository.findById(id);
        if(memberOptional.isPresent()){
            Member member = memberOptional.get();
            member.setIsMembershipActive(true);
            memberRepository.save(member);
            return HttpStatus.OK;
        }
        return HttpStatus.FORBIDDEN;
    }
}
