package entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Size(min=3, max=40, message ="{user.username}")
    @Pattern(regexp = "[^a-zA-Z0-9_]+$")
    @Column(name = "USERNAME")
    private String username;

    @Size(min=3, max=40, message ="{user.username}")
    @Column(name = "USERNAME")
    private String password;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
