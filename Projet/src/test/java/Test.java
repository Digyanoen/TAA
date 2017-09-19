import Server.Endpoint.LoginEndpoint;
import Server.RestServer;
import junit.framework.*;

import javax.ws.rs.core.Response;

public class Test extends TestCase{

    public static LoginEndpoint server;

    public void testCalculer() throws Exception {
        server = new LoginEndpoint();
        Response ret = server.getLogin();

    }
}