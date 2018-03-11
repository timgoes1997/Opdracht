package Authentication.Producers;

import Authentication.cdi.AuthenticatedUser;
import entity.User;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;

@RequestScoped
public class AuthenticatedUserProducer {

    //@Produces
    //@RequestScoped
    //@AuthenticatedUser
    private User authenticatedUser;

    /*
    public void handleAuthenticationEvent(@Observes @AuthenticatedUser String username){
        this.authenticatedUser = findUser(username);
    }*/

    private User findUser(String username){
        return new User();
    }

}
