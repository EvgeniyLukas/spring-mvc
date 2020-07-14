package org.itstep.lukas.controller;

import org.itstep.lukas.dao.hibernateimpl.HibernateStudentDAOImpl;
import org.itstep.lukas.dao.hibernateimpl.HibernateTeacherDAOImpl;
import org.itstep.lukas.dto.StudentDTO;
import org.itstep.lukas.model.Student;
import org.itstep.lukas.model.Teacher;
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

    private final HibernateTeacherDAOImpl hibernateTeacherDAO;

    public ControllerWeb(HibernateStudentDAOImpl hibernateStudentDAO, HibernateTeacherDAOImpl hibernateTeacherDAO) {
        this.hibernateStudentDAO = hibernateStudentDAO;
        this.hibernateTeacherDAO = hibernateTeacherDAO;
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
        //model.addAttribute("teachers", hibernateTeacherDAO.getAll());
        return "student";
    }
    @GetMapping("/teacher")
    public String getTeacherExample(Model model) {
        model.addAttribute("teachers", hibernateTeacherDAO.getAll());
        return "teacher";
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
