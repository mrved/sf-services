package com.thefallenbrain.stayfithub.services.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class WorkoutPlan {
    @Id
    Integer id;

    @OneToMany
    List<Theme> themes;

    @OneToMany
    List<MuscleGroup> muscleGroups;

    @OneToMany
    List<Person> suitableFor;

    @OneToMany
    List<Activity> activities;
}
