package dao.impl;
import dao.UsersDao;
import model.Role;
import model.Token;
import model.User;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository("fakeDao")
public class FakeDao
    implements UsersDao {

    final Set<User> clients = new HashSet<>();
    final Set<Role> roles = new HashSet<>();
    final Set<Token> tokens = new HashSet<>();

    public FakeDao(){
        this.generateFakeClients();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return null;
    }

    @Override
    public Optional<User> getUserByUsername(String username) {

        return clients.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }

    @Override
    public Optional<Token> getToken(Token token) {
        return this.tokens.stream().filter(t->t.equals(token)).findFirst();
    }

    @Override
    public Optional<Token> getTokenByUUID(UUID uuid) {
        return this.tokens.stream().filter(t->t.getId().equals(uuid)).findFirst();
    }

    @Override
    public Optional<Token> getTokenByUserName(String username) {
        return this.tokens.stream()
                .filter(t->t.getUser().getUsername().equals(username)).findFirst();
    }

    @Override
    public boolean addTokenForUser(User user, Token token) {
        int size = this.tokens.size();
        this.tokens.add(new Token(UUID.randomUUID(), DateTime.now().plusMinutes(15),user));
        return size==this.tokens.size();
    }

    @Override
    public boolean refreshToken(Token token) {
        return false;
    }

    @Override
    public boolean addToken(Token token) {
        return false;
    }

    @Override
    public Set<User> getUsers() {
        return null;
    }

    public void generateFakeClients(){


        if(roles.size()==0){
            roles.add(new Role(0,"ADMIN"));
            roles.add(new Role(1,"USER"));
        }
        if (clients.size()==0){


            clients.add(new User(0,"Jan","Pawel",null));
            clients.add(new User(1,"Tomasz","Hajto",null));
            clients.add(new User(2,"Karol","Wojtyla",null));

        }
        System.out.println(clients);
        System.out.println("XDD");

    }

}
