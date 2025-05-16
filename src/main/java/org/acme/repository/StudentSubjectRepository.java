package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.StudentSubject;

@ApplicationScoped
public class StudentSubjectRepository implements PanacheRepository<StudentSubject> {
}
