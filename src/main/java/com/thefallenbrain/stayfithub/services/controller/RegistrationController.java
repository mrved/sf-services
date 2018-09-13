package com.thefallenbrain.stayfithub.services.controller;

import com.thefallenbrain.stayfithub.services.config.encryption.Encoders;
import com.thefallenbrain.stayfithub.services.domain.EndUser;
import com.thefallenbrain.stayfithub.services.domain.Member;
import com.thefallenbrain.stayfithub.services.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Import(Encoders.class)
public class RegistrationController {

    @Autowired
    MemberRepository memberRepository;
    @PostMapping(value = "/login")
    public Member login(@RequestParam String email, @RequestParam String password){
        Optional<Member> memberOption = memberRepository.findByEmailAndPassword(email, password);
        if(!memberOption.isPresent()){
            throw new UsernameNotFoundException("email not found");
        }
        return memberOption.get();
    }

    @PostMapping(value = "/signup")
    public Member createMember(@RequestBody Member member){
        memberRepository.save(member);
        if(member.getPassword() == null){
            member.setPassword("master");
        }
        return login(member.getEmail(), member.getPassword());
    }

}
