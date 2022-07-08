package org.agrotechfields.report.resource;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import org.agrotechfields.report.dto.IslandDto;
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
  @Path("/{id}")
  public Response getById(@PathParam("id") String id) {
    return Response.ok(islandService.findById(id)).build();
  }

  @PATCH
  @RolesAllowed("admin")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{id}/measure")
  public void addReport(@PathParam("id") String id, Measure measure) {
    islandService.addReport(id, measure);
  }

  @PUT
  @RolesAllowed("admin")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{id}")
  public Response editIsland(@PathParam("id") String id, IslandDto islandDto) {
    return Response.ok(islandService.editIsland(id, islandDto)).build();
  }

  @PATCH
  @RolesAllowed("admin")
  @Path("/{ìd}/on")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public void SwitchOn(@PathParam("id") String id) {
    islandService.turnActive(id);
  }

  @PATCH
  @RolesAllowed("admin")
  @Path("/{id}/off")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public void SwitchOff(@PathParam("id") String id) {
    islandService.turnInactive(id);
  }

  @DELETE
  @RolesAllowed("admin")
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteById(@PathParam("id") String id) {
    islandService.removeIslandById(id);
    return Response.noContent().build();
  }

}
