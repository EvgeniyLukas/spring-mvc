package org.itstep.lukas.service;

import org.itstep.lukas.dao.hibernateimpl.HibernateStudentDAOImpl;
import org.itstep.lukas.model.Student;
import org.itstep.lukas.model.Teacher;
import org.itstep.lukas.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    private final HibernateStudentDAOImpl hibernateStudentDAO;

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(HibernateStudentDAOImpl hibernateStudentDAO, StudentRepository studentRepository) {
        this.hibernateStudentDAO = hibernateStudentDAO;
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(Student student) {
        hibernateStudentDAO.save(student);
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void remove(Student student) {

    }

    public List<Teacher> getAllTeachers(Long id) {
        return studentRepository.getAllByTeachers(id);
    }


    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }


    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(Long id) {
        return null;
    }
}
