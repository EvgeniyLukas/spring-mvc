package org.itstep.lukas.service;

import org.itstep.lukas.dao.hibernateimpl.HibernateStudentDAOImpl;
import org.itstep.lukas.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {



    private final HibernateStudentDAOImpl hibernateStudentDAO;


    @Autowired
    public StudentServiceImpl(HibernateStudentDAOImpl hibernateStudentDAO) {
        this.hibernateStudentDAO = hibernateStudentDAO;
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

    @Override
    public Student getById(Long id) {
        return null;
    }
}
