package prototype.beans;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class HelloWorldGreeting {

    public String GetGreeting(String greetType){
        if(greetType.equals("Hello")){
            return "Hello";
        }else{
            return "Hey";
        }
    }

}
