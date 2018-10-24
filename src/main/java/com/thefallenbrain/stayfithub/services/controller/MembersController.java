package com.thefallenbrain.stayfithub.services.controller;

import com.thefallenbrain.stayfithub.services.domain.Member;
import com.thefallenbrain.stayfithub.services.repository.GoalRepository;
import com.thefallenbrain.stayfithub.services.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@BasePathAwareController
@Slf4j
public class MembersController {

	@Autowired
	GoalRepository goalRepository;

	@Autowired
	MemberRepository memberRepository;


	@PutMapping(value = "/members/{id}")
	@ResponseBody
	void updateMember(@PathVariable Integer id,
					  @RequestBody Member member){

		Member member = memberRepository.findById(id).get();
		try {
			member.setName(newMember.getName());
			member.setEmail(newMember.getEmail());
			member.setGender(newMember.getGender());
			member.setPhone(newMember.getPhone());
			member.setDob(newMember.getDob());
			member.setGoal(goalRepository.findById(member.getGoalID()).get());
		}catch (Exception e){

		}
		memberRepository.save(member);

	}

}
