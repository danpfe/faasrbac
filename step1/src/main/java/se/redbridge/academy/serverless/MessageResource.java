package se.redbridge.academy.serverless;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/message")
public class MessageResource {
  @Inject
  private DB db;

  @POST
  public Response doPost(@QueryParam("message") final String message) {
    db.persistMessage(message);

    return Response.ok().build();
  }
}
