package org.agrotechfields.report.resource;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import org.agrotechfields.report.exception.EmptyNameException;
import org.agrotechfields.report.model.Island;
import org.agrotechfields.report.model.Measure;
import org.agrotechfields.report.service.IslandService;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;

@SecurityScheme(
    scheme = "bearer",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT"
)
@Path("/islands")
@ApplicationScoped
public class IslandResource {

  @Inject
  public IslandService islandService;

  @POST
  @RolesAllowed("admin")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
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
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAll() {
    return Response.ok(islandService.getAll()).build();
  }

  @GET
  @PermitAll
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/filter")
  public Response getByName(@QueryParam("name") String name) {
    return Response.ok(islandService.findByName(name)).build();
  }

  @PUT
  @RolesAllowed("admin")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public void addReport(@QueryParam("name") String name, Measure measure) {
    islandService.addReport(name, measure);
  }

  @PUT
  @RolesAllowed("admin")
  @Path("/on")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public void SwitchOn(@QueryParam("name") String name) {
    islandService.turnActive(name);
  }

  @PUT
  @RolesAllowed("admin")
  @Path("/off")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public void SwitchOff(@QueryParam("name") String name) {
    islandService.turnInactive(name);
  }

  @DELETE
  @RolesAllowed("admin")
  @Path("/name")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteIslandByName(@QueryParam("name") String name) {
    islandService.removeIslandByName(name);
    return Response.ok().build();
  }

  @DELETE
  @RolesAllowed("admin")
  @Path("/id")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public void deleteIslandById(@QueryParam("id") ObjectId id) {
    islandService.removeIslandById(id);
  }

}
