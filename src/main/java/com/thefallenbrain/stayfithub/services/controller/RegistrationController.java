package com.thefallenbrain.stayfithub.services.controller;

import com.thefallenbrain.stayfithub.services.domain.Member;
import com.thefallenbrain.stayfithub.services.repository.MemberRepository;
import com.thefallenbrain.stayfithub.services.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RegistrationController {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    RoleRepository roleRepository;
    @PostMapping(value = "/login/application")
    public Member loginApplication(@RequestParam String email, @RequestParam String password){
        System.out.println(email + ", " + password);
        Optional<Member> memberOption = memberRepository.findByEmail(email);
        if(!memberOption.isPresent()){
            throw new UsernameNotFoundException("email not found");
        }
        return memberOption.get();
    }

    @PostMapping(value = "/login/facebook")
    public Member loginFacebook(@RequestParam String email){
        return loginApplication(email, "$2a$08$41fiT9hzk5n0/ZN4257qUuYgAZb2GjNsWOhVLMEUHiQ7riy9shKEa");
    }

    @PostMapping(value = "/signup/application")
    public Member signup(@RequestBody Member member){
        member.setRole(roleRepository.findById(2).get());
        memberRepository.save(member);
        return loginApplication(member.getEmail(), member.getPassword());
    }

    @PostMapping(value = "/signup/facebook")
    public Member signupFacebook(@RequestBody Member member){
        if(member.getPassword() == null || member.getPassword().isEmpty()){
            member.setPassword("$2a$08$41fiT9hzk5n0/ZN4257qUuYgAZb2GjNsWOhVLMEUHiQ7riy9shKEa");
            member.setRole(roleRepository.findById(2).get());
            member = memberRepository.save(member);
            if(member != null)
                return loginApplication(member.getEmail(), member.getPassword());
            else return null;
        }
        return null;
    }

    @PostMapping(value = "/change/password")
    public HttpStatus changePassword(@RequestParam String email, @RequestParam String oldPassword, @RequestParam String newPassword){
       Optional<Member> optionalMember = memberRepository.findByEmailAndPassword(email, oldPassword);
       if(optionalMember.isPresent()){
           Member member = optionalMember.get();
           member.setPassword(newPassword);
           memberRepository.save(member);
           return HttpStatus.OK;

       }
       return HttpStatus.FORBIDDEN;
    }

    @PostMapping(value = "/forgot/password")
    public HttpStatus forgotPassword(@RequestParam String email, @RequestParam String newPassword){
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        if(optionalMember.isPresent()){
            Member member = optionalMember.get();
            member.setPassword(newPassword);
            memberRepository.save(member);
            return HttpStatus.OK;

        }
        return HttpStatus.FORBIDDEN;
    }
}
