package org.itstep.lukas.service;

import org.itstep.lukas.model.Teacher;
import org.itstep.lukas.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    @Override
    public void save(Teacher teacher) {

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


    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }
}
