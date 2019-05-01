package org.launchcode.models.forms;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String email;

    @NotNull
    @Size(min=3, max=15)
    private String password;

    @OneToMany
    @JoinColumn(name = "owner_id")
    private List<Blog> blogs = new ArrayList();

    public User() {}

    public User(String email, String password) {this.email = email;this.password = password;}

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

   // @Entity
   // public static class Menu {

//        @Id
//        @GeneratedValue
//        private int id;
//    }
}