package model;

import java.util.HashSet;

public class User {

    private int id;
    private String username;
    private String password;
    private HashSet<Role> roles;


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

    public HashSet<Role> getRoles() {
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
        System.out.println("hash");
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
