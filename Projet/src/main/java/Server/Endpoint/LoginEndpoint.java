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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Path("/login")
public class LoginEndpoint {

    private static final Logger logger = Logger.getLogger(LoginEndpoint.class.getName());

    @GET
    public Response getLogin() {

        return Response.status(Response.Status.OK).entity("JO").build();
    }

    /**
     * Retrieve all acitivities for a specified user
     * @param id the id of the user
     * @return the list of activities
     */
    @GET
    @Path("/activities-{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getActivities(@PathParam("id") int id){
        User user = DAOFactory.getUserDAO().find(id);
        List<String> list = new ArrayList<String>();
        for (Activity a: user.getActivities()) list.add((a.getName()));
        return list;
    }

    /**
     * Retrieve an activity by its id
     * @param id the id of the activity
     * @return the name and the level of the activity
     */
    @GET
    @Path("/activity/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> getActivityDetails(@PathParam("id") int id) {
        Activity activity = DAOFactory.getActivityDAO().find(id);
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", activity.getName());
        map.put("level", activity.getLevel());
        return map;


    }


}
