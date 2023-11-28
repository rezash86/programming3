package com.jac.mvc.repository;

import com.jac.mvc.entity.Student;

import java.util.List;

//in this interface we create our CRUD methods
public interface StudentRepository {

    void save(Student student);

    List<Student> getAll();

    Student findById(Long id);

    List<Student> findByLastName(String lastName);

    void updateStudent(Student student);

    void deleteStudent(Student student);

    void deleteStudentById(Long id);
}
