package com.example.judge2.web;

import com.example.judge2.model.binding.UserLoginBindingModel;
import com.example.judge2.model.binding.UserRegisterBindingModel;
import com.example.judge2.model.service.UserServiceModel;
import com.example.judge2.security.CurrentUser;
import com.example.judge2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;


    public UserController (UserService userService,ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;

    }

    @GetMapping("/login")
    public String login (Model model) {
        if (!model.containsAttribute ("userLoginBindingModel")) {
            model.addAttribute ("userLoginBindingModel",new UserLoginBindingModel ());
            model.addAttribute ("notFound",false);
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm (@Valid
                                @ModelAttribute
                                        UserLoginBindingModel userLoginBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                HttpSession httpSession) {

        if (bindingResult.hasErrors ()) {
            redirectAttributes
                    .addFlashAttribute ("userLoginBindingModel",userLoginBindingModel);
            redirectAttributes
                    .addFlashAttribute ("org.springframework.validation.BindingResult.userLoginBindingModel",bindingResult);
            return "redirect:login";
        }
        var userServiceModel = this.userService
                .findUserByUsernameAndPassword (userLoginBindingModel.getUsername (),userLoginBindingModel.getPassword ());
        if (userServiceModel == null) {
            redirectAttributes
                    .addFlashAttribute ("userLoginBindingModel",userLoginBindingModel);
            redirectAttributes
                    .addFlashAttribute ("notFound",true);
            return "redirect:login";
        }
        // httpSession.setAttribute ("user",userServiceModel);
        this.userService.login (userServiceModel);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register (Model model) {
        if (!model.containsAttribute ("userRegisterBindingModel")) {
            model.addAttribute ("userRegisterBindingModel",new UserRegisterBindingModel ());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm (@Valid
                                   @ModelAttribute
                                           UserRegisterBindingModel userRegisterBindingModel,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors ()
                || !userRegisterBindingModel.getPassword ()
                .equals (userRegisterBindingModel.getConfirmPassword ())) {
            redirectAttributes
                    .addFlashAttribute ("userRegisterBindingModel",userRegisterBindingModel);
            redirectAttributes
                    .addFlashAttribute ("org.springframework.validation.BindingResult.userRegisterBindingModel",bindingResult);
            return "redirect:register";
        }
        var userServiceModel = modelMapper
                .map (userRegisterBindingModel,UserServiceModel.class);
        this.userService
                .registerUser (userServiceModel);

        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logout () {
        this.userService.logout ();
        return "redirect:/";
    }

    @GetMapping("/profile/{id}")
    public String profile (@PathVariable Long id,Model model) {



        model.addAttribute ("user",
                this.userService.findProfileById(id));

        return "profile";
    }
}
