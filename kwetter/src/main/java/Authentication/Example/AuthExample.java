package Authentication.Example;


import Authentication.cdi.Secured;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("secured/example")
public class AuthExample {

    @GET
    @Path("unsecure/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String unsecure(@PathParam("id") Long id) {
        // This method is not annotated with @Secured
        // The authentication filter won't be executed before invoking this method
        return "Unsecure";
    }

    @GET
    @Secured
    @Path("secure/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String secure(@PathParam("id") Long id) {
        return "Secure";
    }
}
