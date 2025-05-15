package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.StudentDTO;
import org.acme.model.Parent;
import org.acme.model.Student;
import org.acme.service.ParentService;
import org.acme.service.StudentService;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

    @Inject
    StudentService studentService;

    @POST
    public Response createStudent(StudentDTO studentDTO){

        try {
            Student student = new Student();
            student.setStudentId(studentDTO.getStudentId());
            student.setFirstName(studentDTO.getFirstName());
            student.setLastName(studentDTO.getLastName());
            student.setDob(studentDTO.getDob());
            student.setEmail(studentDTO.getEmail());
            student.setContactNum(studentDTO.getContactNum());

            Parent parent = new Parent();
            parent.setParentId(studentDTO.getParentId());

            student.setParent(parent);
            Student createdParent = studentService.createStudent(student);
            StudentDTO responseDTO = new StudentDTO(
                    createdParent.getStudentId(),
                    createdParent.getFirstName(),
                    createdParent.getLastName(),
                    createdParent.getEmail(),
                    createdParent.getDob(),
                    createdParent.getContactNum(),
                    createdParent.getParent().getParentId()
            );
            return Response.status(Response.Status.CREATED).entity(responseDTO).build();
        }catch(IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
