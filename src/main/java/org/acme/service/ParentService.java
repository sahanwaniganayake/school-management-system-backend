package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.acme.model.Parent;
import org.acme.model.Student;
import org.acme.repository.ParentRepository;

import java.util.List;

@ApplicationScoped
public class ParentService {

    @Inject
    ParentRepository parentRepository;

    @Transactional
    public Parent createParent(Parent parent){
        parentRepository.persist(parent);
        return parent;
    }


    public List<Parent> getParents(){
        return parentRepository.listAll();
    }
}
