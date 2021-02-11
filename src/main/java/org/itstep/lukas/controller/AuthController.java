package org.itstep.lukas.controller;

import org.itstep.lukas.model.Student;
import org.itstep.lukas.service.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {


    private final StudentServiceImpl studentService;

    public AuthController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/student/new")
    public String signUp() {
        return "signup";
    }


    @PostMapping("/student/new")
    public String signUp(@ModelAttribute Student student) {
        System.out.println("student = " + student);
        studentService.save(student);
        return "redirect:/student";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(name = "error", required = false)Boolean error,
                        Model model) {
        if(Boolean.TRUE.equals(error)){
            model.addAttribute("error", true);
            System.out.println("error = " + error);
        }
        return "signin";
    }

}
