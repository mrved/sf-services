package com.thefallenbrain.stayfithub.services.controller;

import com.thefallenbrain.stayfithub.services.domain.Member;
import com.thefallenbrain.stayfithub.services.domain.Membership;
import com.thefallenbrain.stayfithub.services.domain.MembershipType;
import com.thefallenbrain.stayfithub.services.repository.MemberRepository;
import com.thefallenbrain.stayfithub.services.repository.MembershipRepository;
import com.thefallenbrain.stayfithub.services.repository.MembershipTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class PaymentController {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MembershipRepository membershipRepository;
    @Autowired
    MembershipTypeRepository membershipTypeRepository;

    @PostMapping(value = "subscription/success")
    @ResponseStatus(HttpStatus.OK)
    void subscription(@RequestParam Integer memberId,
                 @RequestParam Integer membershipTypeId,
                 @RequestParam String paymentId){
        Member member = memberRepository.findById(memberId).get();

        MembershipType membershipType = membershipTypeRepository.findById(membershipTypeId).get();
        // setting up membership
        Membership membership = new Membership();
        membership.setStartDate(new Date());
        membership.setEndDate(afterDays(new Date(), membershipType.getDuration()));
        membership.setMembershipType(membershipType);
        membership.setPaymentId(paymentId);
        membershipRepository.save(membership);
        member.setMembership(membership);
        member.setIsMembershipActive(true);
        memberRepository.save(member);
    }

    Date afterDays(Date date, Long days){
        return new Date(date.getTime() + days * 24 * 60 * 60 * 1000);
    }
}
