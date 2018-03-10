package beans;

import entity.HelloWorld;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@Path("hello")
@SessionScoped
public class HelloWorldBean implements Serializable{
    private String text = "Hello Relexed!";

    private List<HelloWorld> helloes;

    @PostConstruct
    public void initialize() {
        helloes = new ArrayList<>();
        helloes.add(new HelloWorld(1));
        helloes.add(new HelloWorld(2));
        System.out.println(HelloWorldBean.class.getSimpleName() + " was constructed");
    }

    public String getRelaxed() {
        return text;
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Path("create/{helloId}/")
    public HelloWorld createHello(@PathParam("helloId") int hello) {
        HelloWorld helloWorld = new HelloWorld(hello);
        helloes.add(helloWorld);
        return helloWorld;
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path("delete/{helloId}/")
    public List<HelloWorld> deleteHello(@PathParam("helloId") int hello) {
        HelloWorld helloWorld = getHello(hello);
        if(helloWorld == null) {
            return null;
        }else{
            helloes.remove(helloWorld);
        }
        return helloes;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Path("update/{helloId}/")
    public HelloWorld updateHello(@PathParam("helloId") int hello, @QueryParam("text") String text) {
        HelloWorld helloWorld = getHello(hello);
        if(helloWorld == null) {
            helloWorld = new HelloWorld(hello);
            helloWorld.setText(text);
            helloes.add(helloWorld);
        }else{
            helloWorld.setText(text);
        }
        return helloWorld;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("read/{helloId}/")
    public HelloWorld getHello(@PathParam("helloId") int hello) {
        for(HelloWorld h : helloes){
            if(h.getHello() == hello){
                return h;
            }
        }
        return null;
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
