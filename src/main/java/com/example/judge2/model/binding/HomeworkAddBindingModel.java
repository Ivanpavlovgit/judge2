package com.example.judge2.model.binding;

import javax.validation.constraints.Pattern;

public class HomeworkAddBindingModel {
    private String exercise;
    private String gitAddress;

    public String getExercise () {
        return exercise;
    }

    public HomeworkAddBindingModel setExercise (String exercise) {
        this.exercise = exercise;
        return this;
    }
    @Pattern (regexp = "https:\\/\\/github.com\\/.+",message = "Enter valid git address")
    public String getGitAddress () {
        return gitAddress;
    }

    public HomeworkAddBindingModel setGitAddress (String gitAddress) {
        this.gitAddress = gitAddress;
        return this;
    }

    public HomeworkAddBindingModel () {
    }
}
