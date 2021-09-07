package com.example.judge2.service;

import com.example.judge2.model.entity.Exercise;
import com.example.judge2.model.service.ExerciseServiceModel;

import java.util.List;

public interface ExerciseService {
void addExercise(ExerciseServiceModel exerciseServiceModel);

    List<String> findAllExNames ();

    boolean checkIfIsLate (String exercise);

    Exercise findByName (String exercise);
}
