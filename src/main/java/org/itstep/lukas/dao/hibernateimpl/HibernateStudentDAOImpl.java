package org.itstep.lukas.dao.hibernateimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itstep.lukas.dao.StudentDAO;
import org.itstep.lukas.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HibernateStudentDAOImpl implements StudentDAO {


    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateStudentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.openSession();
    }


    @Override
    public void save(Student student) {
        currentSession().save(student);
    }

    @Override
    public void update(Student entity) {


    }

    @Override
    public void remove(Student student) {
        currentSession().remove(student);
    }


    public List<Student> getAll() {
        return currentSession().createQuery("from Student", Student.class).list();
    }

    @Override
    public Student getById(Long aLong) {
        return null;
    }
}
