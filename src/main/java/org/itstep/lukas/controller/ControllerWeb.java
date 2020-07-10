package org.itstep.lukas.controller;

import org.itstep.lukas.dao.hibernateimpl.HibernateStudentDAOImpl;
import org.itstep.lukas.dto.StudentDTO;
import org.itstep.lukas.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class ControllerWeb {

    List<Student> students = new ArrayList<>();


    private final HibernateStudentDAOImpl hibernateStudentDAO;

    public ControllerWeb(HibernateStudentDAOImpl hibernateStudentDAO) {
        this.hibernateStudentDAO = hibernateStudentDAO;
    }


    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", required = false, defaultValue = "noname") String name, Model model) {
        model.addAttribute("massage", "Hello from " + name);
        return "hello";
    }

    @GetMapping("/name/{last_name}")
    public String name(@PathVariable(value = "last_name") String name, Model model) {
        model.addAttribute("massage", "Hello from " + name);
        return "hello";
    }

    @GetMapping("/response")
    @ResponseBody
    public String resp() {
        return "Response Body";
    }


    public Student setTestStudent() {
        Student student = new StudentDTO();
        student.setFirstName("Ivan");
        student.setLastName("Ivanov");
        student.setEmail("ivan@gmai.com");
        return student;
    }


    @GetMapping("/student")
    public String getStudentExample(Model model) {
        model.addAttribute("student", setTestStudent());
        model.addAttribute("students", hibernateStudentDAO.getAll());
        model.addAttribute("students1", hibernateStudentDAO.getAll());
        model.addAttribute("students2", hibernateStudentDAO.getAll());
        //System.out.println(students);
        return "student";
    }


    @GetMapping("/students")
    public String getStudents(Model model) {
        model.addAttribute("student", setTestStudent());
        List<Student> students = Arrays.asList(
                new Student("Petr", "Petrov", 12, "petro@gmail.com"),
                new Student("Oleg", "klichko", 33, "kiev@gmail.com"),
                new Student("Rhonda", "Christian", 55, "ckisrt@gmail.com")
        );
        model.addAttribute("students", students);
        return "student";
    }

    @GetMapping("/object")
    public String obj(Model model) {
        model.addAttribute("obj", setTestStudent());
        return "obj";
    }

    @GetMapping("/student/new")
    public String signUp() {
        return "signup";
    }


    @PostMapping("/student/new")
    public String signUp(@ModelAttribute Student student) {
        //students.add(student);
        System.out.println("student = " + student);
        hibernateStudentDAO.save(student);
        return "redirect:/student";
    }
}
