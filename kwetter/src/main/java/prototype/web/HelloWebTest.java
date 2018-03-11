package prototype.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("helloweb")
public class HelloWebTest {

    @GET
    public String GetGreeting(){
        return "Hello";
    }
}
