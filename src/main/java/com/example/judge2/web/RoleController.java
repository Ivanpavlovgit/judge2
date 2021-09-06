package com.example.judge2.web;

import com.example.judge2.model.entity.RoleNameEnum;
import com.example.judge2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
@RequestMapping("/roles")
public class RoleController {
    private final ModelMapper modelMapper;
    private final UserService userService;


    public RoleController (ModelMapper modelMapper,UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/add")
    public String add (Model model) {
        model.addAttribute ("userNames",this.userService.findAllUserNames ());

        return "role-add";
    }

    @PostMapping("/add")
    public String addConfirm (@RequestParam String username,
                              @RequestParam String role) {
this.userService.changeRole(username,RoleNameEnum.valueOf (role.toUpperCase()));
        return "redirect:/";
    }
}
