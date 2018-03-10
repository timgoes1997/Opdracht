package beans;

import entity.HelloWorld;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Named
@Path("hello")
@RequestScoped
public class HelloWorldBean {
    private String text = "Hello Relexed!";

    @PostConstruct
    public void initialize() {
        System.out.println(HelloWorldBean.class.getSimpleName() + " was constructed");
    }

    public String getRelaxed() {
        return text;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{helloId}/")
    public HelloWorld getHello(@PathParam("helloId") int hello) {
        return new HelloWorld(hello);
    }

    /**
     * Retrieves representation of an instance of helloWorld.HelloWorld
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getHtml() {
        return "<html lang=\"en\"><body><h1>Hello, World!!</h1></body></html>";
    }
}
