package Server.Endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ParamConverter;
import java.util.logging.Logger;

@Path("/login")
public class LoginEndpoint {

    private static final Logger logger = Logger.getLogger(LoginEndpoint.class.getName());

    @GET
    public Response getLogin() {

        return Response.status(Response.Status.OK).entity("JO").build();
    }
}
