package com.thefallenbrain.stayfithub.services.controller;

import com.thefallenbrain.stayfithub.services.domain.*;
import com.thefallenbrain.stayfithub.services.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MembershipRepository membershipRepository;
    @Autowired
    MembershipTypeRepository membershipTypeRepository;
    @Autowired
    FitnessCenterRepository fitnessCenterRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @PostMapping(value = "subscription/success")
    @ResponseStatus(HttpStatus.OK)
    void subscription(@RequestParam Integer memberId,
                 @RequestParam Integer membershipTypeId,
                 @RequestParam String paymentId,
                      @RequestParam Integer fitnessCenterId){
        Member member = memberRepository.findById(memberId).get();

        MembershipType membershipType = membershipTypeRepository.findById(membershipTypeId).get();
        FitnessCenter fitnessCenter = fitnessCenterRepository.findById(fitnessCenterId).get();
        // setting up membership
		Payment payment = new Payment();
        Membership membership = new Membership();
        membership.setStartDate(new Date());
        membership.setEndDate(afterDays(new Date(), membershipType.getDuration()));
        membership.setMembershipType(membershipType);
        membership.setPaymentId(paymentId);
        membershipRepository.save(membership);
        member.setMembership(membership);
        member.setIsMembershipActive(true);


        payment.setEndDate(membership.getEndDate());
        payment.setStartDate(membership.getStartDate());
        payment.setPaymentId(paymentId);
        payment.setMemberId(memberId);
        payment.setAmount(membershipType.getPrice());
        payment.setMemberShipType(membershipType.getDescription());
        payment.setMemberName(member.getName());
        paymentRepository.save(payment);
        member.setFitnessCenter(fitnessCenter);
        memberRepository.save(member);
    }


    Date afterDays(Date date, Long days){
        return new Date(date.getTime() + days * 24 * 60 * 60 * 1000);
    }
}
