package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.model.Student;
import org.acme.repository.StudentRepository;

@ApplicationScoped
public class StudentService {

    @Inject
    StudentRepository studentRepository;

    @Transactional
    public Student createStudent(Student student){
        studentRepository.persist(student);
        return student;
    }
}
