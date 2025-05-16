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
    public Response createParent(ParentDTO parentDTO) {
        Parent parent = new Parent();
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

    @Path("/{id}")
    @GET
    public Response getParentById(@PathParam("id") Long parentId) {

        try {
            Parent parent = parentService.getParentById(parentId);

            ParentDTO responseDTO = new ParentDTO(
                    parent.getParentId(),
                    parent.getFirstName(),
                    parent.getLastName(),
                    parent.getEmail(),
                    parent.getContactNum()
            );

            return Response.status(Response.Status.OK).entity(responseDTO).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @Path("/{id}")
    @PUT
    public Response updateParent(@PathParam("id") Long id, ParentDTO parentDTO) {
        try {
            Parent parent = new Parent();
            parent.setParentId(parentDTO.getParentId());
            parent.setFirstName(parentDTO.getFirstName());
            parent.setLastName(parentDTO.getLastName());
            parent.setEmail(parentDTO.getEmail());
            parent.setContactNum(parentDTO.getContactNum());
            Parent updatedParent = parentService.updateParent(id, parent);

            ParentDTO responseDTO = new ParentDTO(
                    updatedParent.getParentId(),
                    updatedParent.getFirstName(),
                    updatedParent.getLastName(),
                    updatedParent.getEmail(),
                    updatedParent.getContactNum()

            );
            return Response.status(Response.Status.OK).entity(responseDTO).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteParent(@PathParam("id") Long id){
        try{
            parentService.deleteParent(id);
            return Response.status(Response.Status.OK).entity("Parent deleted successfully").build();
        }catch(IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
