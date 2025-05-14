package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.model.Parent;
import org.acme.repository.ParentRepository;

@ApplicationScoped
public class ParentService {

    @Inject
    ParentRepository parentRepository;

    @Transactional
    public Parent createParent(Parent parent){
        parentRepository.persist(parent);
        return parent;
    }
}
