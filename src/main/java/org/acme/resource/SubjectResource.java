package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.SubjectDTO;
import org.acme.model.Subject;
import org.acme.service.SubjectService;

@Path("/subjects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SubjectResource {

    @Inject
    SubjectService subjectService;

    @POST
    public Response addSubject(SubjectDTO subjectDTO){
        try{
            Subject subject= new Subject();
            subject.setSubjectName(subjectDTO.getSubjectName());
            subject.setSubjectDescription(subjectDTO.getSubjectDescription());
            Subject createdSubject = subjectService.addSubject(subject);

            SubjectDTO responseDTO = new SubjectDTO(
                    createdSubject.getSubjectId(),
                    createdSubject.getSubjectName(),
                    createdSubject.getSubjectDescription()
            );
            return Response.status(Response.Status.CREATED).entity(responseDTO).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
