package Authentication.Endpoint;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.auth.login.LoginException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

@Named
@Path("auth")
@RequestScoped
public class AuthenticationEndpoint {

    @PersistenceContext
    EntityManager em;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("username") String username, @FormParam("password") String password){
        try{
            authenticate(username, password);

            String token = issueToken(username);

            Response res = Response.ok(token).build();
            return res;

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).entity("Entered a invalid username or password, please try again!").build();
        }
    }

    private void authenticate(String username, String password) throws Exception
    {
        //TODO: Authenticate with database instead of hardcoded shizzle
        if(!("admin".equals(username) && "wachtwoord".equals(password))){
            throw new LoginException("Entered a invalid username or password, please try again!");
        }
    }

    private String issueToken(String username){
        //TODO: implement JWT framework for getting tokens
        Random random = new SecureRandom();
        String token = new BigInteger(130, random).toString(32);
        return "Bearer " + token;
    }
}
