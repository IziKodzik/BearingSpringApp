package service;

import model.Role;
import model.Token;
import model.User;

import java.util.Set;

public interface SecurityService {

    Token authenticateUser(User user);
    String redirect(Token token);
    Set<Role> parseToken(Token token);



}
