package com.example.judge2.service;

import com.example.judge2.model.service.CommentServiceModel;

import java.util.Map;

public interface CommentService {
    void add (CommentServiceModel serviceModel,Long homeworkId);

    double findAvgScore ();

    Map<Integer,Integer> findScoreMap ();
}
