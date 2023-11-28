package com.jac.mvc.repository;

import com.jac.mvc.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Student> getAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student where lastName=:paramLastName", Student.class);
        query.setParameter("paramLastName", lastName);
//        return query.getSingleResult(); //gives an error since we have multiple records
        return query.getResultList();
    }

    @Override
    public void updateStudent(Student student) {
        //approach 1
//        Student foundStd = entityManager.find(Student.class, student.getId());
//        //if you want to check if foundStu exist or not
//        foundStd.setLastName(student.getLastName());
//        entityManager.merge(foundStd); // it does the update

        //approach 2
//        entityManager.createQuery("UPDATE Student SET lastName=:paramLastName")
//                .setParameter("paramLastName", student.getLastName())
//                .executeUpdate();

        //approach 3
        entityManager.merge(student);

    }

    @Override
    public void deleteStudent(Student student) {

        //if you don't have the exact student to be deleted
        //first you need to fetch it !!!

        //otherwise if you are sending the same exact object that resides in db
        //then just pass the object to remove method
        entityManager.remove(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        Student foundStd = entityManager.find(Student.class, id);
        if(foundStd != null){
            entityManager.remove(foundStd);
        }
    }
}
