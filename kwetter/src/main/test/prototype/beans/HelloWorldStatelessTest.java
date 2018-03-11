package prototype.beans;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HelloWorldStatelessTest {

    HelloWorldStateless hws;

    @Before
    public void init(){
        this.hws = new HelloWorldStateless();
        this.hws.greeting = mock(HelloWorldGreeting.class);
    }

    @Test
    public void getGreeting(){
        when(this.hws.greeting.GetGreeting(Matchers.anyObject())).thenReturn("hey");
        String greeting = this.hws.getGreeting("Hello");
        assertEquals(greeting, "hey");
    }

}