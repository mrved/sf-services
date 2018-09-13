package com.thefallenbrain.stayfithub.services.controller;

import com.thefallenbrain.stayfithub.services.domain.Exercise;
import com.thefallenbrain.stayfithub.services.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

public class ExerciseController {
	@Autowired
	private ExerciseRepository exerciseRepository;

	@GetMapping("/exercises")
	public List<Exercise> retrieveAllExercises() {
		return exerciseRepository.findAll();
	}

	@PostMapping("exercises")
	public Exercise addExercise(@RequestBody Exercise exercise) {
		return exerciseRepository.save(exercise);
	}

	@PutMapping("exercises/{id}")
	public Exercise updateExercise(@PathVariable Integer id, @RequestBody Exercise exercise) {
		Optional<Exercise> exerciseOptional = exerciseRepository.findById(id);
		if (!exerciseOptional.isPresent())
			throw new NullPointerException();
		exercise.setId(id);
		return exerciseRepository.save(exercise);
	}
}
