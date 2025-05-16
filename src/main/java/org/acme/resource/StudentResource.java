package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.ParentDTO;
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






    @Path("/{id}")
    @PUT
    public Response updateStudent(@PathParam("id")Long id, StudentDTO studentDTO){
        try{
            Student student = new Student();
            student.setStudentId(studentDTO.getStudentId());
            student.setFirstName(studentDTO.getFirstName());
            student.setLastName(studentDTO.getLastName());
            student.setEmail(studentDTO.getEmail());
            student.setDob(studentDTO.getDob());
            student.setContactNum(studentDTO.getContactNum());

            Parent parent = new Parent();
            parent.setParentId(studentDTO.getParentId());
            student.setParent(parent);

            Student updatedStudent = studentService.updateStudent(id,student);



            StudentDTO responseDTO = new StudentDTO(
                    updatedStudent.getStudentId(),
                    updatedStudent.getFirstName(),
                    updatedStudent.getLastName(),
                    updatedStudent.getEmail(),
                    updatedStudent.getDob(),
                    updatedStudent.getContactNum(),
                    updatedStudent.getParent().getParentId()

            );
            return Response.status(Response.Status.OK).entity(responseDTO).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteStudent(@PathParam("id") Long id ){
        try{
            studentService.deleteStudent(id);
            return Response.status(Response.Status.OK).entity("Student deleted Successfully").build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
