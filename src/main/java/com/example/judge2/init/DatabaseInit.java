package com.example.judge2.init;

import com.example.judge2.service.RoleService;
import com.example.judge2.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {
    private final RoleService roleService;
    private final UserService userService;

    public DatabaseInit (RoleService roleService,UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run (String... args) throws Exception {
        System.out.println ("I have started");

        this.roleService.initRoles ();
        this.userService.initAdmin ();
    }
}
