package com.example.judge2.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class UserRegisterBindingModel {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String git;

    @Length(min = 2, message = "Username length must be minimum 2 characters")
    public String getUsername () {
        return this.username;
    }

    public UserRegisterBindingModel setUsername (String username) {
        this.username = username;
        return this;
    }

    @Length(min = 3, message = "Password length must be minimum 3 characters")
    public String getPassword () {
        return this.password;
    }

    public UserRegisterBindingModel setPassword (String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword () {
        return this.confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword (String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @Email(message = "Enter valid email address")
    public String getEmail () {
        return this.email;
    }

    public UserRegisterBindingModel setEmail (String email) {
        this.email = email;
        return this;
    }
@Pattern (regexp = "https:\\/\\/github.com\\/.+",message = "Enter valid git address")
    public String getGit () {
        return this.git;
    }

    public UserRegisterBindingModel setGit (String git) {
        this.git = git;
        return this;
    }

    public UserRegisterBindingModel () {
    }
}
