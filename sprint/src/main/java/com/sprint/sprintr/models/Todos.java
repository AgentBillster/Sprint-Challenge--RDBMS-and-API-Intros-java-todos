package com.sprint.sprintr.models;

import javax.persistence.*;

@Entity
@Table(name = "todos")

public class Todos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;



    @Column(nullable = false)
    private String description;
    private boolean completed = false;


    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private Users user;

    public Todos() {
    }

    public Todos(String description, boolean completed, Users user) {
        this.description = description;
        this.completed = completed;
        this.user = user;
    }

    public long getTodoid() {
        return todoid;
    }

    public void setTodoid(long todoid) {
        this.todoid = todoid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Todos{" +
                "todoid=" + todoid +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", user=" + user +
                '}';
    }
}
