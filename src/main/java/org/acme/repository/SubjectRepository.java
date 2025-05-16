package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Subject;

@ApplicationScoped
public class SubjectRepository implements PanacheRepository<Subject> {
}
