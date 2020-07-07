package org.itstep.lukas.dto;

import org.itstep.lukas.model.Student;

public class StudentDTO extends Student {

    public  StudentDTO setTestStudent(){
        StudentDTO studentDTO = new StudentDTO();
        setFirstName("Ivan");
        setLastName("Ivanov");
        setEmail("ivan@gmai.com");
        return studentDTO;
    }
}
