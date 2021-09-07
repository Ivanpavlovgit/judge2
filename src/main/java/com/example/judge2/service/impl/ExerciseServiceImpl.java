package com.example.judge2.service.impl;

import com.example.judge2.model.entity.Exercise;
import com.example.judge2.model.service.ExerciseServiceModel;
import com.example.judge2.repository.ExerciseRepository;
import com.example.judge2.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    @Override
    public List<String> findAllExNames () {
        return this.exerciseRepository.findAllExNames ();
    }

    @Override
    public boolean checkIfIsLate (String exercise) {

        var exerciseEntity = this.exerciseRepository
                .findByName (exercise)
                .orElse (null);

        return exerciseEntity.getDueDate ()
                .isBefore (LocalDateTime.now ());
    }

    @Override
    public Exercise findByName (String exercise) {
        return this.exerciseRepository.findByName (exercise).orElse (null);
    }
}
