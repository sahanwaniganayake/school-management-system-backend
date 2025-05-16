package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.model.Parent;
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

    @Transactional
    public Student updateStudent(Long id, Student student){

        Student existingStudent = studentRepository.findById(id);

        if(existingStudent == null){
            throw new IllegalArgumentException("Student not found for given ID");
        }

        if (student.getParent() != null && student.getParent().getParentId() != 0) {
            Long parentId = student.getParent().getParentId();
            Parent parent = parentRepository.findById(parentId);
            if (parent == null) {
                throw new IllegalArgumentException("Parent not found");
            }
            existingStudent.setParent(student.getParent());
        }
        if (student.getFirstName() != null) {
            existingStudent.setFirstName(student.getFirstName());
        }
        if (student.getLastName() != null) {
            existingStudent.setLastName(student.getLastName());
        }
        if (student.getEmail() != null) {
            existingStudent.setEmail(student.getEmail());
        }
        if (student.getDob() != null) {
            existingStudent.setDob(student.getDob());
        }
        if (student.getContactNum() != null) {
            existingStudent.setContactNum(student.getContactNum());
        }


        return existingStudent;
    }
}
