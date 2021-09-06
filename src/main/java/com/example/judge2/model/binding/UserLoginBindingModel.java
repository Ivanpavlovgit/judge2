package com.example.judge2.model.binding;

import org.hibernate.validator.constraints.Length;

public class UserLoginBindingModel {
    private String  username;
    private String  password;

    @Length(min = 2, message = "Username length must be minimum 2 characters")
    public String getUsername () {
        return this.username;
    }

    public UserLoginBindingModel setUsername (String username) {
        this.username = username;
        return this;
    }
    @Length(min = 3, message = "Password length must be minimum 3 characters")
    public String getPassword () {
        return this.password;
    }

    public UserLoginBindingModel setPassword (String password) {
        this.password = password;
        return this;
    }

    public UserLoginBindingModel () {
    }
}
