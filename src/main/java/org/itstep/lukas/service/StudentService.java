package org.itstep.lukas.service;

import org.itstep.lukas.model.Student;

public interface StudentService {
    void save(Student student);

    void update(Student student);

    void remove(Student student);

    Student getById(Long id);
}
