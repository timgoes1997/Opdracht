package prototype.entity;

import java.io.Serializable;

public class HelloWorld implements Serializable {

    private int hello;
    private String text;

    public HelloWorld(int hello){
        this.hello = hello;
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
