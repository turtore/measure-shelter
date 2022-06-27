package org.agrotechfields.resource;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import org.agrotechfields.exception.EmptyNameException;
import org.agrotechfields.model.Island;
import org.agrotechfields.model.Measure;
import org.agrotechfields.service.IslandService;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@ApplicationScoped
@Path("/islands")
public class IslandResource {

  @Inject
  public IslandService islandService;

  @POST
  @RolesAllowed({"admin, drone"})
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/add")
  public Response addIsland(Island island) {
    try {
      islandService.addIsland(island);
      return Response.created(URI.create("Created")).build();
    } catch (EmptyNameException e) {
      return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
  }

  @GET
  @PermitAll
  public Response getAll() {
    return Response.ok(islandService.getAll()).build();
  }

  @GET
  @PermitAll
  @Path("/filter")
  public Response getByName(@QueryParam("name") String name) {
    return Response.ok(islandService.findByName(name)).build();
  }

  @PUT
  @RolesAllowed({"admin, drone"})
  @Consumes(MediaType.APPLICATION_JSON)
  public void addReport(@QueryParam("name") String name, Measure measure) {
    islandService.addReport(name, measure);
  }

  @PUT
  @RolesAllowed({"admin, drone"})
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/on")
  public void SwitchOn(@QueryParam("name") String name) {
    islandService.turnActive(name);
  }

  @PUT
  @RolesAllowed({"admin, drone"})
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/off")
  public void SwitchOff(@QueryParam("name") String name) {
    islandService.turnInactive(name);
  }

  @DELETE
  @RolesAllowed({"admin, drone"})
  @Path("/name")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response deleteIslandByName(@QueryParam("name") String name) {
    islandService.removeIslandByName(name);
    return Response.ok().build();
  }

  @DELETE
  @RolesAllowed({"admin, drone"})
  @Path("/id")
  @Consumes(MediaType.APPLICATION_JSON)
  public void deleteIslandById(@QueryParam("id") ObjectId id) {
    islandService.removeIslandById(id);
  }

}
