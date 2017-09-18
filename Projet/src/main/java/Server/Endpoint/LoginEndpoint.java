package Server.Endpoint;

import Server.Model.Activity;
import Server.Model.User;
import Server.Repository.DAOFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ParamConverter;
import java.util.List;
import java.util.logging.Logger;

@Path("/login")
public class LoginEndpoint {

    private static final Logger logger = Logger.getLogger(LoginEndpoint.class.getName());

    @GET
    public Response getLogin() {

        return Response.status(Response.Status.OK).entity("JO").build();
    }

    @GET
    @Path("/activities-{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Activity> getActivities(@PathParam("id") String id){
        User user = DAOFactory.getUserDAO().find(id);
        return user.getActivities();

    }
}
