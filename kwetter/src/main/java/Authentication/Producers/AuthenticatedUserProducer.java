package Authentication.Producers;

import entity.User.User;

import javax.enterprise.context.RequestScoped;

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
