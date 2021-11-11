package edu.unbosque.Taller_5.servlets;


import edu.unbosque.Taller_5.services.OfficialService;
import edu.unbosque.Taller_5.services.UserAppService;
import edu.unbosque.Taller_5.servlets.pojos.OfficialPOJO;
import edu.unbosque.Taller_5.servlets.pojos.UserAppPOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.registry.infomodel.User;
import java.util.Optional;

@Path("/userapp")
public class UserAppResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UserAppPOJO userapp){

        Optional<UserAppPOJO> persistedUser = Optional.of(new UserAppService().saveUserApp(
                userapp.getUsername(), userapp.getPassword(), userapp.getEmail(), userapp.getRole()));

        if (userapp.getRole().equals("official")){

            Optional<OfficialPOJO> persistedOfficial = Optional.of(new OfficialService().saveOfficial(
                    userapp.getOfficial().getName()));

        }else if(userapp.getRole().equals("owner")){

        }else if(userapp.getRole().equals("vet")){

        }

        if (persistedUser.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedUser.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("User could not be created")
                    .build();
        }
    }
}