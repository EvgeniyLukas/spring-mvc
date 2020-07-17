package org.itstep.lukas.repository;

import org.itstep.lukas.model.Student;
import org.itstep.lukas.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Teacher> getAllByTeachers(Long id);

    Student findByEmail(String email);
}
