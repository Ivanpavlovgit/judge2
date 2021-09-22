package com.example.judge2.service.impl;

import com.example.judge2.model.entity.Homework;
import com.example.judge2.model.service.HomeworkServiceModel;
import com.example.judge2.repository.HomeworkRepository;
import com.example.judge2.repository.UserRepository;
import com.example.judge2.security.CurrentUser;
import com.example.judge2.service.ExerciseService;
import com.example.judge2.service.HomeworkService;
import com.example.judge2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    private final HomeworkRepository homeworkRepository;
    private final ExerciseService exerciseService;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public HomeworkServiceImpl (HomeworkRepository homeworkRepository,ExerciseService exerciseService,CurrentUser currentUser,UserRepository userRepository,UserService userService,ModelMapper modelMapper) {
        this.homeworkRepository = homeworkRepository;
        this.exerciseService = exerciseService;
        this.currentUser = currentUser;

        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addHomework (String exercise,String gitAddress) {
        var homework = new Homework ();
        homework.setGitAddress (gitAddress)
                .setAddedOn (LocalDateTime.now ())
                .setExercise (this.exerciseService.findByName (exercise))
                .setAuthor (this.userService.findById (this.currentUser.getId ()));
        this.homeworkRepository.save (homework);
    }

    @Override
    public HomeworkServiceModel findHomeWorkForScoring () {
        return this.homeworkRepository
                .findTop1ByOrderByComments ()
                .map (homework -> this.modelMapper
                        .map (homework,HomeworkServiceModel.class))
                .orElse (null);

    }

    @Override
    public Homework findById (Long homeworkId) {
        return this.homeworkRepository.findById (homeworkId).orElse (null);
    }
}
