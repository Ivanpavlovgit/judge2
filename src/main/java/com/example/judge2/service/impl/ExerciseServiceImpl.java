package com.example.judge2.service.impl;

import com.example.judge2.model.entity.Exercise;
import com.example.judge2.model.service.ExerciseServiceModel;
import com.example.judge2.repository.ExerciseRepository;
import com.example.judge2.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl (ExerciseRepository exerciseRepository,ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addExercise (ExerciseServiceModel exerciseServiceModel) {
        var exercise = modelMapper.map (exerciseServiceModel,Exercise.class);
        this.exerciseRepository.save (exercise);
    }
}
