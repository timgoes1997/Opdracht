package prototype.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HelloWebTestTest {

    private Client client;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        this.client = ClientBuilder.newClient();
        this.target = this.client.target("http://localhost:8080/kwetter/webapi/helloweb");
    }

    @Test
    public void GetGreeting(){
        Response response = this.target.request().get();
        assertThat(response.getStatus(), is(200));
    }

    @After
    public void tearDown() throws Exception {
    }
}