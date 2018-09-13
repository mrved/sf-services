package com.thefallenbrain.stayfithub.services.controller;

import java.util.List;
import com.thefallenbrain.stayfithub.services.domain.MembershipOption;
import com.thefallenbrain.stayfithub.services.repository.MembershipOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MembershipOptionsController {
    @Autowired
    MembershipOptionRepository membershipOptionRepository;

    @GetMapping(value = "/membershipOptions")
    List<MembershipOption> getAll(){
        return membershipOptionRepository.findAll();
    }
}
