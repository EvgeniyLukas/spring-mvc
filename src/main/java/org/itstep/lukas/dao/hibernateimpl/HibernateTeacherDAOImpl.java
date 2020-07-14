package org.itstep.lukas.dao.hibernateimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itstep.lukas.dao.TeacherDAO;
import org.itstep.lukas.model.Student;
import org.itstep.lukas.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HibernateTeacherDAOImpl implements TeacherDAO {


    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateTeacherDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.openSession();
    }


    @Override
    public void save(Teacher teacher) {
        currentSession().save(teacher);
    }

    public List<Teacher> getAll() {
        return currentSession().createQuery("from Teacher", Teacher.class).list();

    }

    @Override
    public void update(Teacher teacher) {

    }

    @Override
    public void remove(Teacher teacher) {

    }

    @Override
    public Teacher getById(Long id) {
        return null;
    }
}
