package org.agrotechfields.resource;

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
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/add")
  public Response addIsland(Island island) {
    return Response.created(URI.create("Created")).build();
  }

  @GET
  public Response getAll() {
    return Response.ok(islandService.getAll()).build();
  }

  @GET
  @Path("/filter")
  public Response getByName(@QueryParam("name") String name) {
    return Response.ok(islandService.findByName(name)).build();
  }

  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  public void addReport(@QueryParam("name") String name, Measure measure) {
    islandService.addReport(name, measure);
  }

  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  public Response deleteIslandByName(@QueryParam("name") String name) {
    islandService.removeIslandByName(name);
    return Response.ok().build();
  }

  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  public void deleteIslandById(@QueryParam("id") ObjectId id) {
    islandService.removeIslandById(id);
  }

}
