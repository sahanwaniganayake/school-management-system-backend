package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.model.StudentSubject;
import org.acme.repository.StudentSubjectRepository;
import org.acme.repository.StudentRepository;

@ApplicationScoped
public class StudentSubjectService {

    @Inject
    StudentSubjectRepository studentCourseRepository;

    @Inject
    StudentRepository studentRepository;

    @Transactional
    public StudentSubject enrollStudent(StudentSubject studentCourse){
        if(studentRepository.count("studentId",studentCourse.getStudent().getStudentId())>0){
            throw new IllegalArgumentException("Student not found");
        }

        studentCourseRepository.persist(studentCourse);
        return studentCourse;
    }
}
