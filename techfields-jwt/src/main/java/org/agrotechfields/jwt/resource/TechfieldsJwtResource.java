package org.agrotechfields.jwt.resource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.agrotechfields.jwt.service.TechfieldsJwtService;

@ApplicationScoped
@Path("/jwt")
public class TechfieldsJwtResource {

  @Inject
  TechfieldsJwtService techfieldsJwtService;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public Response getJwt() {
    String jwt = techfieldsJwtService.generateJwt();

    return Response.ok(jwt).build();
  }

}
