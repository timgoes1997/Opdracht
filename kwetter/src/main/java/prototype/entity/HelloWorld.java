package prototype.entity;

import java.io.Serializable;

public class HelloWorld implements Serializable {

    private int hello;
    private String text;

    public HelloWorld(){

    }

    public HelloWorld(int hello){
        this.hello = hello;
    }

    public HelloWorld(int hello, String text){
        this.hello = hello;
        this.text = text;
    }

    public int getHello() {
        return hello;
    }

    public void setHello(int hello) {
        this.hello = hello;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
