package org.acme.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Parent;

@ApplicationScoped
public class ParentRepository implements PanacheRepository<Parent> {
}
