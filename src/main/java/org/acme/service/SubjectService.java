package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.model.Subject;
import org.acme.repository.StudentRepository;
import org.acme.repository.SubjectRepository;

@ApplicationScoped
public class SubjectService {

    @Inject
    SubjectRepository subjectRepository;

    @Transactional
    public Subject addSubject(Subject subject){
        if(subjectRepository.count("subjectName",subject.getSubjectName())>0){
            throw new IllegalArgumentException("Subject already exists");
        }
        subjectRepository.persist(subject);
        return subject;
    }
}
