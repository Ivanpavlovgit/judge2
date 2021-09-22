package com.example.judge2.model.service;

import java.time.LocalDate;

public class HomeworkServiceModel {
    private Long id;
    private LocalDate addedOn;
    private String gitAddress;
    private UserServiceModel author;

    public Long getId () {
        return id;
    }

    public HomeworkServiceModel setId (Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getAddedOn () {
        return addedOn;
    }

    public HomeworkServiceModel setAddedOn (LocalDate addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    public String getGitAddress () {
        return gitAddress;
    }

    public HomeworkServiceModel setGitAddress (String gitAddress) {
        this.gitAddress = gitAddress;
        return this;
    }

    public UserServiceModel getAuthor () {
        return author;
    }

    public HomeworkServiceModel setAuthor (UserServiceModel author) {
        this.author = author;
        return this;
    }

    public HomeworkServiceModel () {
    }
}
