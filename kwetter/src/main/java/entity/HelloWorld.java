package entity;

import java.io.Serializable;

public class HelloWorld implements Serializable {

    private int hello;

    public HelloWorld(int hello){
        this.hello = hello;
    }

    public int getHello() {
        return hello;
    }

    public void setHello(int hello) {
        this.hello = hello;
    }
}
