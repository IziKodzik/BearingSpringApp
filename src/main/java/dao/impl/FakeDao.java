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

    public void generateFakeClients(){


        if(roles.size()==0){
            roles.add(new Role(0,"ADMIN"));
            roles.add(new Role(1,"USER"));
        }
        if (clients.size()==0){


            clients.add(new User(0,"Jan","Pawel"));
            clients.iterator().next().getRoles().add(new Role(0,"USER"));
            clients.add(new User(1,"Tomasz","Hajto",new Role(1,"ADMIN"),new Role(0,"USER")));
            clients.add(new User(2,"Karol","Wojtyla",new Role(1, "ADMIN")));

        }
        System.out.println(clients);
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
    public Optional<Token> getTokenByUUID(String uuid) {

        return this.tokens.stream().filter(token -> token.getId().toString().equals(uuid)).findFirst();
    }

    @Override
    public Optional<Token> getTokenByUserName(String username) {
        return this.tokens.stream()
                .filter(t->t.getUser().getUsername().equals(username)).findFirst();
    }

    @Override
    public boolean addTokenForUser(User user, Token token) {
      token.setUser(user);
      return this.addToken(token);
    }

    @Override
    public boolean refreshToken(Token token) {
        Optional<Token> maybeToken = this.tokens.stream().filter(t->t.equals(token)).findFirst();
        if(!maybeToken.isPresent())
            return false;
        maybeToken.get().setExpireDate(DateTime.now().plusMinutes(15));
        return true;
    }

    @Override
    public boolean addToken(Token token) {
        return this.tokens.add(token);
    }

    @Override
    public Set<User> getUsers() {
        return this.clients;
    }

    @Override
    public Set<Token> getTokens() {
        return this.tokens;
    }

    @Override
    public boolean deleteToken(Token token) {
        return this.tokens.remove(token);
    }
}
