package com.example.judge2.service.impl;

import com.example.judge2.model.entity.RoleNameEnum;
import com.example.judge2.model.entity.User;
import com.example.judge2.model.service.UserServiceModel;
import com.example.judge2.repository.UserRepository;
import com.example.judge2.security.CurrentUser;
import com.example.judge2.service.RoleService;
import com.example.judge2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;
    private final CurrentUser currentUser;

    public UserServiceImpl (UserRepository userRepository,ModelMapper modelMapper,RoleService roleService,CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser (UserServiceModel userServiceModel) {
        var user = modelMapper.map (userServiceModel,User.class);
        user.setRole (this.roleService.findRole (RoleNameEnum.USER));

        this.userRepository.save (user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword (String username,String password) {
        return this.userRepository.findByUsernameAndPassword (username,password)
                .map (user -> modelMapper.map (user,UserServiceModel.class))
                .orElse (null);
    }

    @Override
    public void login (UserServiceModel userServiceModel) {
        this.currentUser
                .setId (userServiceModel.getId ())
                .setUsername (userServiceModel.getUsername ())
                .setRole (userServiceModel.getRole ().getRole ());


    }

    @Override
    public void logout () {
        this.currentUser
                .setId (null)
                .setUsername (null)
                .setRole (null);
    }

    @Override
    public void initAdmin () {
        User user = new User ();
        user.setRole (this.roleService.findRole (RoleNameEnum.ADMIN))
                .setUsername ("misho")
                .setPassword ("111")
                .setEmail ("azsumadmin@admin");
        if (this.userRepository.findByUsernameAndPassword (user.getUsername (),user.getPassword ()).isEmpty ()) {
            this.userRepository.save (user);
        }
    }

    @Override
    public List<String> findAllUserNames () {
        return this.userRepository
                .findAllUserNames ();
    }

    @Override
    public void changeRole (String username,RoleNameEnum roleNameEnum) {
        var user = this.userRepository
                .findByUsername (username)
                .orElse (null);


        if (user.getRole ().getRole () != roleNameEnum) {
            user.setRole (this.roleService.findRole (roleNameEnum));
        }

        this.userRepository.save (user);
    }

    @Override
    public User findById (Long id) {
        return this.userRepository.findById (id).orElse (null);
    }
}
