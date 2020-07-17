package org.itstep.lukas.service;

import org.itstep.lukas.model.Student;
import org.itstep.lukas.model.Teacher;

public interface TeacherService {

    void save(Teacher teacher);

    void update(Teacher teacher);

    void remove(Teacher teacher);

    Teacher getById(Long id);
}
