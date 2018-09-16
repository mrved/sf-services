package com.thefallenbrain.stayfithub.services.controller;

import com.thefallenbrain.stayfithub.services.domain.Member;
import com.thefallenbrain.stayfithub.services.domain.Trainer;
import com.thefallenbrain.stayfithub.services.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members")
    public List<Member> retrieveUsers(){
        return memberRepository.findAll();
    }

    @GetMapping("/member/{id}")
    public Member retrieveUserByID(@PathVariable Integer id){
        Optional<Member> member =  memberRepository.findById(id);

        if(!member.isPresent())
            throw new NullPointerException();
        else
            return member.get();
    }

    @GetMapping("/membersByTrainerId/{id}")
    public List<Member> findMembersByTrainerId(@PathVariable Integer id){
        return memberRepository.findMembersByTrainerId(id);
    }

    @GetMapping("/membersByHeadTrainerId/{id}")
    public List<Member> findMembersByHeadTrainerId(@PathVariable Integer id){
        return memberRepository.findMembersByHeadTrainerId(id);
    }

    @GetMapping("/membersByFitnessCenter/{id}")
    public List<Member> findMembersByHeadFitnessCenterId(@PathVariable Integer id){
        return memberRepository.findMembersByFitnessCenterId(id);
    }

    @Transactional
    @DeleteMapping("/member/{id}")
    public void deleteMember(@PathVariable Integer id){
        memberRepository.deleteById(id);
    }


    @PostMapping("/member")
    public Member createMember(@RequestBody Member member){
        return memberRepository.save(member);
    }

    @PutMapping("member/{id}")
    public Member updateMember(@PathVariable Integer id, @RequestBody Member member){
        Optional<Member> memberOptional = memberRepository.findById(id);
        if (!memberOptional.isPresent())
            throw new NullPointerException();
        member.setId(id);
        return memberRepository.save(member);
    }
}
