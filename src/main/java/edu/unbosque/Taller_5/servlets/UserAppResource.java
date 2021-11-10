package edu.unbosque.Taller_5.servlets;


import edu.unbosque.Taller_5.servlets.pojos.OfficialPOJO;
import edu.unbosque.Taller_5.servlets.pojos.OwnerPOJO;
import edu.unbosque.Taller_5.servlets.pojos.UserAppPOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/userapp")
public class UserAppResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UserAppPOJO userapp, OfficialPOJO official){
        return  Response.status(Response.Status.CREATED)
                .entity(new UserAppPOJO(userapp.getUsername(),userapp.getPassword()
                        ,userapp.getEmail(), userapp.getRole(), official))
                .build();

    }



}