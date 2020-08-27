package dao;


import model.Token;
import model.User;

import java.util.*;

public interface UsersDao {

    Optional<User> getUserById(int id);
    Optional<User> getUserByUsername(String username);
    boolean addTokenForUser(User user,Token token);
    boolean addToken(Token token);
    Set<User> getUsers();
    Optional<Token> getToken(Token token);
    Optional<Token> getTokenByUserName(String username);
    Optional<Token> getTokenByUUID(UUID uuid);
    boolean refreshToken(Token token);
    //    Optional<Set<Role>> getRolesByUser(User user);



}
