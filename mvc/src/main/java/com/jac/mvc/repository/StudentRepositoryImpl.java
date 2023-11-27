package com.jac.mvc.repository;

import com.jac.mvc.entity.Student;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository{

    private final EntityManager entityManager;

    @Autowired
    public StudentRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
//    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
}
