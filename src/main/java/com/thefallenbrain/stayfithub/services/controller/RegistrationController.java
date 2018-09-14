package com.thefallenbrain.stayfithub.services.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.thefallenbrain.stayfithub.services.domain.*;
import com.thefallenbrain.stayfithub.services.exception.InvalidMemberDetailException;
import com.thefallenbrain.stayfithub.services.exception.UserNotFoundException;
import com.thefallenbrain.stayfithub.services.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class RegistrationController {

    @Autowired
    EndUserRepository endUserRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    FrontdeskAdminRepository frontdeskAdminRepository;

    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    HeadTrainerRepository headTrainerRepository;

    @Autowired
    RoleRepository roleRepository;


    @RequestMapping(value = "/login")
    public EndUser login(@RequestParam String email,
                         @RequestParam String password)
            throws UserNotFoundException {
        try {
            EndUser endUser = endUserRepository.findByEmailAndPassword(email, password);
            if(endUser == null)
                throw new Exception();
            return endUser;
        }
        catch (Exception e){
            throw new UserNotFoundException();
        }
    }

    @PostMapping(value = "/signup")
    public Member signup(@RequestBody Member member)
            throws InvalidMemberDetailException {
            member.setRole(roleRepository.findByName("GENERAL"));
            member.setDesignation("Member");
        try{
            return memberRepository.save(member);
        } catch (Exception e) {
            throw new InvalidMemberDetailException();
        }
    }

}
