package com.example.judge2.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {
    /*•	score – an Integer.
    •	textContent – a very long String
    •	author – a User
    •	homework – a Homework
    */
    private Integer score;
    private String textContent;
    private User author;
    private Homework homework;

    @Column(name = "score")
    public Integer getScore () {
        return this.score;
    }

    public Comment setScore (Integer score) {
        this.score = score;
        return this;
    }

    @Column(name = "text_content",columnDefinition = "TEXT")
    public String getTextContent () {
        return this.textContent;
    }

    public Comment setTextContent (String textContent) {
        this.textContent = textContent;
        return this;
    }

    @ManyToOne
    public User getAuthor () {
        return this.author;
    }

    public Comment setAuthor (User author) {
        this.author = author;
        return this;
    }

    @ManyToOne
    public Homework getHomework () {
        return this.homework;
    }

    public Comment setHomework (Homework homework) {
        this.homework = homework;
        return this;
    }

    public Comment () {
    }
}
