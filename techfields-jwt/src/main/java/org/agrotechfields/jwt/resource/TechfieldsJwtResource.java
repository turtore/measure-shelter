package org.agrotechfields.jwt.resource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.agrotechfields.jwt.service.TechfieldsJwtService;

@ApplicationScoped
@Path("/jwt")
public class TechfieldsJwtResource {

  @Inject
  TechfieldsJwtService techfieldsJwtService;

  public Response getJwt() {
    String jwt = techfieldsJwtService.generateJwt();

    return Response.ok(jwt).build();
  }

}
