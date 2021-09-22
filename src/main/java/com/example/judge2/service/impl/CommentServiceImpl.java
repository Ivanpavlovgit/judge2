package com.example.judge2.service.impl;

import com.example.judge2.model.entity.Comment;
import com.example.judge2.model.service.CommentServiceModel;
import com.example.judge2.repository.CommentRepository;
import com.example.judge2.security.CurrentUser;
import com.example.judge2.service.CommentService;
import com.example.judge2.service.HomeworkService;
import com.example.judge2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final HomeworkService homeworkService;

    public CommentServiceImpl (CommentRepository commentRepository,ModelMapper modelMapper,CurrentUser currentUser,UserService userService,HomeworkService homeworkService) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.homeworkService = homeworkService;
    }

    @Override
    public void add (CommentServiceModel serviceModel,Long homeworkId) {
        Comment comment = this.modelMapper
                .map (serviceModel,Comment.class)
                .setAuthor (this.userService.findById (this.currentUser.getId ()))
                .setHomework (this.homeworkService.findById(homeworkId));
        this.commentRepository.save (comment);
    }
}
