package org.agrotechfields.resource;

import org.agrotechfields.model.Island;
import org.agrotechfields.repository.IslandRepository;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/islands")
public class IslandResource {

  @Inject
  IslandRepository islandRepository;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/add")
  public void addIsland(Island island) {
    islandRepository.persist(island);
  }

  @GET
  public Response getAll() {
    return Response.ok(islandRepository.listAll()).build();
  }

}
