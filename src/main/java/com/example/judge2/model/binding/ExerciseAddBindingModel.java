package com.example.judge2.model.binding;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class ExerciseAddBindingModel {
    private String name;
    private LocalDateTime startedOn;
    private LocalDateTime dueDate;

    @Size(min = 2, message = "Fix the name")
    public String getName () {
        return name;
    }

    public ExerciseAddBindingModel setName (String name) {
        this.name = name;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @PastOrPresent(message = "Fix the date")
    public LocalDateTime getStartedOn () {
        return startedOn;
    }

    public ExerciseAddBindingModel setStartedOn (LocalDateTime startedOn) {
        this.startedOn = startedOn;
        return this;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "Fix the date")
    public LocalDateTime getDueDate () {
        return dueDate;
    }

    public ExerciseAddBindingModel setDueDate (LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ExerciseAddBindingModel () {
    }
}
