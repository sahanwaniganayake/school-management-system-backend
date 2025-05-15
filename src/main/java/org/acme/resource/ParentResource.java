package org.acme.resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.ParentDTO;
import org.acme.model.Parent;
import org.acme.service.ParentService;

@Path("/api/parents")
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
        Parent createdParent = parentService.createParent(parent);
        ParentDTO responseDTO = new ParentDTO(
                createdParent.getParentId(),
                createdParent.getFirstName(),
                createdParent.getLastName()
        );
        return Response.status(Response.Status.CREATED).entity(responseDTO).build();
    }
}
