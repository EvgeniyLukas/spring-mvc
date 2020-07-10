package org.itstep.lukas.dao.jdbctamplateimpl;

import org.itstep.lukas.dao.StudentDAO;
import org.itstep.lukas.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcStudentDAOImpl implements StudentDAO {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcStudentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void save(Student student) {
        jdbcTemplate.update("insert into student values (?,?,?,?)",
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                student.getEmail());
    }

    @Override
    public void update(Student entity) {

    }

    @Override
    public void remove(Student entity) {

    }

    @Override
    public Student getById(Long aLong) {
        return null;
    }
}
