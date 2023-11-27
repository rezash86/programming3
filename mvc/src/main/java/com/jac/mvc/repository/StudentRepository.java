package com.jac.mvc.repository;

import com.jac.mvc.entity.Student;

//in this interface we create our CRUD methods
public interface StudentRepository {

    void save(Student student);
}
