package entity.User;

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
    @Column(name = "USERNAME", unique = true)
    private String username;

    @Size(min=3, max=40, message ="{user.username}")
    @Column(name = "PASSWORD")
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(){

    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.role = UserRole.User;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
