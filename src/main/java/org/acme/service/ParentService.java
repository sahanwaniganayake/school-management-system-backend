package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.acme.model.Parent;
import org.acme.model.Student;
import org.acme.repository.ParentRepository;
import org.acme.repository.StudentRepository;

import java.util.List;

@ApplicationScoped
public class ParentService {

    @Inject
    ParentRepository parentRepository;

    @Inject
    StudentRepository studentRepository;

    @Transactional
    public Parent createParent(Parent parent){

        if(parentRepository.count("email",parent.getEmail())>0){
            throw new IllegalArgumentException("Email already exists");
        }

        if(studentRepository.count("email",parent.getEmail())>0){
            throw new IllegalArgumentException("This email registered as a Parent");
        }
        parentRepository.persist(parent);
        return parent;
    }


    public Parent getParentById(Long id){
        if(parentRepository.findById(id) == null) {
            throw new IllegalArgumentException("Parent not found for given ID");
        }
        return parentRepository.findById(id);
    }



    @Transactional
    public Parent updateParent(Long id, Parent parent){

        Parent existingParent = parentRepository.findById(id);
        if (existingParent == null) {
            throw new IllegalArgumentException("Parent not found for given Id");
        }

        if (parent.getFirstName() != null) {
            existingParent.setFirstName(parent.getFirstName());
        }
        if (parent.getLastName() != null) {
            existingParent.setLastName(parent.getLastName());
        }
        if (parent.getEmail() != null) {
            existingParent.setEmail(parent.getEmail());
        }
        if (parent.getContactNum() != null) {
            existingParent.setContactNum(parent.getContactNum());
        }


        return existingParent;
    }

}
