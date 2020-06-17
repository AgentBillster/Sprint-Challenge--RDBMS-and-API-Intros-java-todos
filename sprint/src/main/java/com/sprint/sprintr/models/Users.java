package com.sprint.sprintr.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @Column(nullable = false, unique = true)
    private String username;
    private String password;
    private String primaryemail;

    //----------------------all relationships-----------------//
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Transient
    @JsonIgnoreProperties(value = "user", allowSetters = true)
    private List<Todos> todos = new ArrayList<>();




    public Users() {
    }

    public Users(String username, String password, String primaryemail) {
        this.username = username;
        this.password = password;
        this.primaryemail = primaryemail;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPrimaryemail() {
        return primaryemail;
    }

    public void setPrimaryemail(String primaryemail) {
        this.primaryemail = primaryemail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Todos> getTodos() {
        return todos;
    }

    public void setTodos(List<Todos> todos) {
        this.todos = todos;
    }


    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", primaryemail='" + primaryemail + '\'' +
                ", password='" + password + '\'' +
                ", todos=" + todos +
                '}';
    }
}
