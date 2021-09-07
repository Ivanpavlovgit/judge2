package com.example.judge2.web;

import com.example.judge2.model.binding.HomeworkAddBindingModel;
import com.example.judge2.service.ExerciseService;
import com.example.judge2.service.HomeworkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/homework")
public class HomeWorkController {
    private final ExerciseService exerciseService;
private final HomeworkService homeworkService;
    public HomeWorkController (ExerciseService exerciseService,HomeworkService homeworkService) {
        this.exerciseService = exerciseService;
        this.homeworkService = homeworkService;
    }

    @GetMapping("/add")
    public String add (Model model) {
        if (!model.containsAttribute ("homeworkAddBindingModel")) {
            model.addAttribute ("homeworkAddBindingModel",new HomeworkAddBindingModel ());
            model.addAttribute ("isLate",false);
        }
        model.addAttribute ("exNames",this.exerciseService.findAllExNames ());
        return "homework-add";
    }

    @PostMapping("/add")
    private String addConfirm (@Valid HomeworkAddBindingModel homeworkAddBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors ()) {
            redirectAttributes.addFlashAttribute ("homeworkAddBindingModel",homeworkAddBindingModel);
            redirectAttributes.addFlashAttribute ("org.springframework.validation.BindingResult.homeworkAddBindingModel",bindingResult);
            return "redirect:add";
        }

        boolean isLate = this.exerciseService
                .checkIfIsLate (homeworkAddBindingModel.getExercise ());
        if(isLate){
            redirectAttributes.addFlashAttribute ("homeworkAddBindingModel",homeworkAddBindingModel);
            redirectAttributes.addFlashAttribute ("isLate",true);
        }
        this.homeworkService
                .addHomework(homeworkAddBindingModel.getExercise (),homeworkAddBindingModel.getGitAddress ());
        return "redirect:/";
    }
}
