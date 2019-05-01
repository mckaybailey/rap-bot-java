package org.launchcode.models.forms;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by LaunchCode
 */
@Entity
public class Blog {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    public String title;

    public int owner_id;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    public String body;

    @ManyToOne
    private User user;

    //@ManyToMany(mappedBy = "cheeses")
    //private List<User> users;

    public Blog(String name, String description, int owner_id) {
        this.title = name;
        this.body = description;
        this.owner_id=owner_id;
    }

    public Blog() { }

    public int getId() {
        return id;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public String getDescription() {
        return body;
    }

    public void setDescription(String description) {
        this.body = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User category) {
        this.user = category;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }
}