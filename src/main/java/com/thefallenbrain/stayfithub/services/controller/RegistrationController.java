package com.thefallenbrain.stayfithub.services.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.thefallenbrain.stayfithub.services.domain.*;
import com.thefallenbrain.stayfithub.services.exception.InvalidMemberDetailException;
import com.thefallenbrain.stayfithub.services.exception.UserNotFoundException;
import com.thefallenbrain.stayfithub.services.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.Random;

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
                      @RequestParam String password,
                      @RequestParam Boolean authenticated,
                      HttpServletResponse response)
            throws UserNotFoundException {
        try {
            EndUser endUser = null;
            if (!authenticated) {
                endUser = endUserRepository.findByEmailAndPassword(email, password);
                if (endUser == null)
                    throw new Exception();
            } else {
                endUser = endUserRepository.findByEmail(email);
                if (endUser == null)
                    throw new Exception();
            }
            String s = "/members/" + (endUser.getId());
            response.sendRedirect(s);
        } catch (Exception e) {
            throw new UserNotFoundException();
        }
    }

    @Autowired
    public JavaMailSender emailSender;

    @PostMapping(value = {"/signup/{type}", "/signup"})
    public void signup(@RequestBody Member member,
                       @PathVariable Optional<String> type,
                       HttpServletResponse response)
            throws InvalidMemberDetailException {
        member.setRole(roleRepository.findByName("GENERAL"));
        member.setDesignation("Member");
        try {

            Random rnd = new Random();
            int magicPin = 100000 + rnd.nextInt(900000);
            if (type.isPresent() && !type.get().equalsIgnoreCase("facebook")) {
                member.setMagicPin(magicPin);
                SimpleMailMessage message = new SimpleMailMessage();
                try {
                    message.setTo(member.getEmail());
                    message.setText("Welcome to Stayfit, Have a fit life!\n" +
                            "Use this pin " + magicPin + " to verify your account.");
                    emailSender.send(message);
                } catch (MailException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Unable to send mail");
                }
            }
            else {
                member.setPassword("master");
            }
            memberRepository.save(member);
            String s = "/members/" + (member.getId());
            response.sendRedirect(s);
        } catch (Exception e) {
            throw new InvalidMemberDetailException();
        }
    }

    @GetMapping(value = "/forgot/{email}")
    public void forgot(@PathVariable String email, HttpServletResponse response) {
        Member member = memberRepository.findByEmail(email);
        Random rnd = new Random();
        int magicPin = 100000 + rnd.nextInt(900000);
        member.setMagicPin(magicPin);
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            message.setTo(member.getEmail());
            message.setText(
                    "Use this pin " + magicPin + " to reset your password.");
            emailSender.send(message);
        } catch (MailException e) {
            System.out.println(e.getMessage());
            System.out.println("Unable to send mail");
        }
        memberRepository.save(member);
        String s = "/members/" + (member.getId());
        try {
            response.sendRedirect(s);
        } catch (Exception e) {

        }
    }

    @GetMapping(value = "/resend/{email}")
    public void resend(@PathVariable String email, HttpServletResponse response) {
        Member member = memberRepository.findByEmail(email);
        Random rnd = new Random();
        int magicPin = 100000 + rnd.nextInt(900000);
        member.setMagicPin(magicPin);
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            message.setTo(member.getEmail());
            message.setText(
                    "Use this pin " + magicPin);
            emailSender.send(message);
        } catch (MailException e) {
            System.out.println(e.getMessage());
            System.out.println("Unable to send mail");
        }
        memberRepository.save(member);
        String s = "/members/" + (member.getId());
        try {
            response.sendRedirect(s);
        } catch (Exception e) {

        }
    }

}
