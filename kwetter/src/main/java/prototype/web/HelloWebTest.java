package prototype.web;

import prototype.entity.HelloWorld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("helloweb")
public class HelloWebTest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public HelloWorld GetGreeting(){
        HelloWorld helloWorld = new HelloWorld(5);
        helloWorld.setText("test");
        return helloWorld;
    }
}
