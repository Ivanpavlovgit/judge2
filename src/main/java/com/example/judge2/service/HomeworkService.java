package com.example.judge2.service;

import com.example.judge2.model.entity.Homework;
import com.example.judge2.model.service.HomeworkServiceModel;

public interface HomeworkService {
    void addHomework (String exercise,String gitAddress);

    HomeworkServiceModel findHomeWorkForScoring ();

    Homework findById (Long homeworkId);
}
