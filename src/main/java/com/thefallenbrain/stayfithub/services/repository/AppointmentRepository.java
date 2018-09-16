package com.thefallenbrain.stayfithub.services.repository;

import com.thefallenbrain.stayfithub.services.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
}
