package com.thefallenbrain.stayfithub.services.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.thefallenbrain.stayfithub.services.domain.Appointment;
import com.thefallenbrain.stayfithub.services.domain.Member;
import com.thefallenbrain.stayfithub.services.exception.AppointmentAlreadyBookedException;
import com.thefallenbrain.stayfithub.services.repository.AppointmentRepository;
import com.thefallenbrain.stayfithub.services.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@BasePathAwareController
public class AppointmentController {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    MemberRepository memberRepository;



    @PostMapping(value = "members/{id}/addAppointments")
    @ResponseBody
    void addAppointment(@PathVariable Integer id, @RequestBody Appointment appointment, HttpServletResponse response) throws IOException, AppointmentAlreadyBookedException {
        Member member = memberRepository.findById(id).get();
        List<Appointment> appointmentList = member.getAppointments();
        for (Appointment appointment1 : appointmentList) {
            if (appointment1.getDate().getDate() == appointment.getDate().getDate()) {
                throw new AppointmentAlreadyBookedException();
            }
        }
        Appointment app = appointmentRepository.save(appointment);
        appointmentList.add(app);
        member.setAppointments(appointmentList);
        memberRepository.save(member);
    }

    @GetMapping(value = "members/{id}/todaysAppointments")
    @ResponseBody
    List<Appointment> getTodaysAppointments(@PathVariable Integer id) {
        List<Appointment> list = new ArrayList<>();
        Member member = memberRepository.findById(id).get();
        for (Appointment appointment : member.getAppointments()) {
            if (appointment.getDate().getDate() == new Date().getDate()) {
                    list.add(appointment);
            }
        }
        return list;
    }

    @GetMapping(value = "members/{id}/appointments")
    @ResponseBody
    List<Appointment> getAllAppointments(@PathVariable Integer id) {
        List<Appointment> list = new ArrayList<>();
        Member member = memberRepository.findById(id).get();
        for (Appointment appointment : member.getAppointments()) {
            if(appointment.getTimeAttended() == null || appointment.getTimeAttended().isEmpty())
                list.add(appointment);
        }
        return list;
    }
}
