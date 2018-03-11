package Authentication;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.security.auth.login.LoginException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Named
@Path("auth")
@RequestScoped
public class AuthenticationEndpoint {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("username") String username, @FormParam("password") String password){
        try{
            authenticate(username, password);

            String token = issueToken(username);

            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).entity("Entered a invalid username or password, please try again!").build();
        }
    }

    private void authenticate(String username, String password) throws Exception
    {
        if(!("admin".equals(username) && "wachtwoord".equals(password))){
            throw new LoginException("Entered a invalid username or password, please try again!");
        }
    }

    private String issueToken(String username){
        return "Basic Token";
    }
}
