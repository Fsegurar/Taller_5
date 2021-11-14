package edu.unbosque.Taller_5.servlets;

import edu.unbosque.Taller_5.services.PetService;
import edu.unbosque.Taller_5.servlets.pojos.PetPOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("users/{user_id}/pets")
public class PetResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("user_id") Integer user_id, PetPOJO pet){

        Optional<PetPOJO> persistedPet = Optional.of(new PetService().savePet(
                pet.getMicrochip(), pet.getName(), pet.getSpecies(), pet.getRace(), pet.getSize(),
                pet.getSex(), pet.getPicture(), user_id));

        if (persistedPet.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedPet.get())
                    .build();
        } else {
            return Response.status(400)
                    .build();
        }

    }

}
