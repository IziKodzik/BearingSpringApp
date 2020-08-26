package model;

import java.util.HashSet;

public class User {

    private int id;
    private String name;
    private String password;
    private HashSet<Role> roles;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(){}

    public User(int id,String name, String password, HashSet<Role> roles) {
        this.name = name;
        this.password = password;
        this.roles = roles;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashSet<Role> getRoles() {
        return roles;
    }

    public void setRoles(HashSet<Role> roles) {
        this.roles = roles;
    }
}
