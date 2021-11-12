package edu.unbosque.Taller_5.servlets;


import edu.unbosque.Taller_5.services.OfficialService;
import edu.unbosque.Taller_5.services.OwnerService;
import edu.unbosque.Taller_5.services.UserAppService;
import edu.unbosque.Taller_5.services.VetService;
import edu.unbosque.Taller_5.servlets.pojos.OfficialPOJO;
import edu.unbosque.Taller_5.servlets.pojos.OwnerPOJO;
import edu.unbosque.Taller_5.servlets.pojos.UserAppPOJO;
import edu.unbosque.Taller_5.servlets.pojos.VetPOJO;

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
            persistedOfficial.get().setUsername(userapp.getUsername());
            persistedUser.get().setOfficial(persistedOfficial.get());
        }else if(userapp.getRole().equals("owner")){
            Optional<OwnerPOJO> persistedOwner = Optional.of(new OwnerService().saveOwner(
                    userapp.getOwner().getName(), userapp.getOwner().getAddress(), userapp.getOwner().getNeighborhood()));
            persistedOwner.get().setUsername(userapp.getUsername());
            persistedUser.get().setOwner(persistedOwner.get());
        }else if(userapp.getRole().equals("vet")){
            Optional<VetPOJO> persistedVet = Optional.of(new VetService().saveVet(
                    userapp.getOfficial().getName(), userapp.getVet().getAddress(), userapp.getVet().getNeighborhood()));
            persistedVet.get().setUsername(userapp.getUsername());
            persistedUser.get().setVet(persistedVet.get());
        }

        if (persistedUser.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedUser.get())
                    .build();
        } else {
            return Response.status(400)
                    .build();
        }
    }

    @PUT
    @Path("/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("username") String username, UserAppPOJO userapp){

        Optional<UserAppPOJO> persistedUser = null;
        if(userapp.getEmail()!=null){

             persistedUser = Optional.of(new UserAppService()
                    .editEmailByUsername(username, userapp.getEmail()));
        }

        if (userapp.getOfficial()!=null){
            new OfficialService().editNameByUsername(username, userapp.getOfficial().getName());
        }else if(userapp.getOwner()!=null){
            if(userapp.getOwner().getName()!=null){
                new OwnerService().editNameByUsername(username, userapp.getOwner().getName());
            }
            if(userapp.getOwner().getAddress()!=null){
                new OwnerService().editAddressByUsername(username, userapp.getOwner().getAddress());
            }
            if(userapp.getOwner().getNeighborhood()!=null){
                new OwnerService().editNeighborhoodByUsername(username, userapp.getOwner().getNeighborhood());
            }
        }else if(userapp.getVet()!=null){
            if(userapp.getVet().getName()!=null){
                new VetService().editNameByUsername(username, userapp.getVet().getName());
            }
            if(userapp.getVet().getAddress()!=null){
                new VetService().editAddressByUsername(username, userapp.getVet().getAddress());
            }
            if(userapp.getVet().getNeighborhood()!=null){
                new VetService().editNeighborhoodByUsername(username, userapp.getVet().getNeighborhood());
            }
        }

        if (persistedUser.isPresent()) {
            return Response.status(Response.Status.OK)
                    .build();
        } else {
            return Response.status(400)
                    .build();
        }

    }

}