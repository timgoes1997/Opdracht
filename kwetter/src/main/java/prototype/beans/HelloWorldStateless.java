package prototype.beans;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class HelloWorldStateless {

    @Inject
    HelloWorldGreeting greeting;

    public String getGreeting(String Greeting){
        String greet = greeting.GetGreeting(Greeting);
        return greet;
    }

}
