package com.thefallenbrain.stayfithub.services.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.thefallenbrain.stayfithub.services.domain.*;
import com.thefallenbrain.stayfithub.services.exception.InvalidMemberDetailException;
import com.thefallenbrain.stayfithub.services.exception.UserNotFoundException;
import com.thefallenbrain.stayfithub.services.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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
    public void login(@RequestParam String email,
                         @RequestParam String password, HttpServletResponse response)
            throws UserNotFoundException {
        try {
            EndUser endUser = endUserRepository.findByEmailAndPassword(email, password);
            if(endUser == null)
                throw new Exception();
            String s = "/members/" + (endUser.getId());
            response.sendRedirect(s);
        }
        catch (Exception e){
            throw new UserNotFoundException();
        }
    }

    @PostMapping(value = "/signup")
    public Member signup(@RequestBody Member member, HttpServletResponse response)
            throws InvalidMemberDetailException {
            member.setRole(roleRepository.findByName("GENERAL"));
            member.setDesignation("Member");
        try{
            memberRepository.save(member);
            return member;
        } catch (Exception e) {
            throw new InvalidMemberDetailException();
        }
    }

}
