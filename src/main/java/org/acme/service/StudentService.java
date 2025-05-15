package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.model.Student;
import org.acme.repository.ParentRepository;
import org.acme.repository.StudentRepository;

@ApplicationScoped
public class StudentService {

    @Inject
    StudentRepository studentRepository;

    @Inject
    ParentRepository parentRepository;

    @Transactional
    public Student createStudent(Student student){
        if(studentRepository.count("email",student.getEmail())>0){
            throw new IllegalArgumentException("Email already exists");
        }

        if(parentRepository.findById(student.getParent().getParentId())==null){
            throw new IllegalArgumentException("Parent does not exists");
        }

        if(parentRepository.count("email",student.getEmail())>0){
            throw new IllegalArgumentException("This email registered as a Parent");
        }
        studentRepository.persist(student);
        return student;
    }
}
