package Authentication.Endpoint;

import entity.User.User;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Named
@Stateless
@Path("reg")
public class RegistrationEndpoint {
    @PersistenceContext(unitName = "kwetterPU")
    EntityManager em;

    @Inject AuthenticationEndpoint authenticationEndpoint;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response registrate(@FormParam("username") String username, @FormParam("password") String password){
        try{
            User user = new User(username, password);

            em.persist(user);

            Response res = Response.accepted().build();
            return res;

        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity("Either the username already exists or something went wrong!").build();
        }
    }
}
