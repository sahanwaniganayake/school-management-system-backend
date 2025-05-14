package org.acme.resource;

import jakarta.inject.Inject;
import org.acme.service.StudentService;

public class StudentResource {

    @Inject
    StudentService studentService;
}
