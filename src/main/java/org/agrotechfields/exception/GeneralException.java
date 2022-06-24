package org.agrotechfields.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GeneralException implements ExceptionMapper<Exception> {

  @Override
  public Response toResponse(Exception exception) {

    if (exception instanceof NameNotFoundException) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage()).build();
    }


    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity("Internal Error").build();
  }
}
