package com.example.judge2.service;

import com.example.judge2.model.entity.RoleNameEnum;
import com.example.judge2.model.entity.User;
import com.example.judge2.model.service.UserServiceModel;
import com.example.judge2.model.view.UserProfileViewModel;

import java.util.List;

public interface UserService {
    void registerUser (UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword (String username,String password);

    void login (UserServiceModel userServiceModel);

    void logout ();

    void initAdmin ();

   List<String> findAllUserNames ();

    void changeRole (String username,RoleNameEnum roleNameEnum);

    User findById (Long id);

    UserProfileViewModel findProfileById (Long id);

    Long findUsersCount ();
}

