package model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class User {


    private int id;
    private String username;
    private String password;
    private Set<Role> roles= new HashSet<>();

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = new HashSet<>();
    }

    public User(String username, String password) {
        this.username=username;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(){}

    public User(int id, String username, String password, HashSet<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.id = id;
    }

    public User(int id,String username,String password, Role... roles){
        this.id = id;
        this.username = username;
        this.password = password;
        Set<Role> toAdd = new HashSet<>();
        Collections.addAll(toAdd, roles);
        this.roles = toAdd;

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(HashSet<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("equal");
        if(!(obj instanceof User))
            return false;
        else
          return this.username.equals(((User) obj).username);
    }

}
