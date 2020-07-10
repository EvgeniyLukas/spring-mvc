package org.itstep.lukas.test;

import org.hibernate.SessionFactory;
import org.itstep.lukas.dao.hibernateimpl.HibernateStudentDAOImpl;
import org.itstep.lukas.model.Student;
import org.itstep.lukas.service.StudentServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Ivan");
        student.setLastName("Ivanov");
        student.setAge(22);
        student.setEmail("1234@gmail.com");

        System.out.println("student = " + student);



    }
}
