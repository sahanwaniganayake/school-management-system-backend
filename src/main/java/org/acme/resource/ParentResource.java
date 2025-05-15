package org.acme.resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.ParentDTO;
import org.acme.model.Parent;
import org.acme.model.Student;
import org.acme.service.ParentService;

import java.util.List;

@Path("/parents")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ParentResource {

    @Inject
    ParentService parentService;

    @POST
    public Response createParent(ParentDTO parentDTO){
        Parent parent= new Parent();
        parent.setParentId(parentDTO.getParentId());
        parent.setFirstName(parentDTO.getFirstName());
        parent.setLastName(parentDTO.getLastName());
        parent.setEmail(parentDTO.getEmail());
        parent.setContactNum(parentDTO.getContactNum());

        Parent createdParent = parentService.createParent(parent);
        ParentDTO responseDTO = new ParentDTO(
                createdParent.getParentId(),
                createdParent.getFirstName(),
                createdParent.getLastName(),
                createdParent.getEmail(),
                createdParent.getContactNum()
        );
        return Response.status(Response.Status.CREATED).entity(responseDTO).build();
    }

    @GET
    public Response getStudent(@QueryParam("id") Long parentId){
        if(parentId != null){
            Parent parent = parentService.getParents(parentId);
            if(parent !=null){
                return Response.status(Response.Status.OK).entity(parent).build();
            }else{
                return Response.status(Response.Status.BAD_REQUEST).entity("Parent not found").build();
            }
        }else {
            List<Parent> parents = parentService.getParents();
            return Response.status(Response.Status.OK).entity(parents).build();
        }
    }
}
