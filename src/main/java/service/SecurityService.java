package service;

import model.Role;
import model.Token;
import model.User;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

public interface SecurityService {

    Token authenticateUser(User user);
    String redirect(Token token);
    Set<Role> parseTokenToRoles(Token token);
    User parseTokenToUser(Token token);
    boolean hasRole(Cookie request, String role);
    boolean hasId(ServletRequest request,int id);
    boolean hasRoleAndId(ServletRequest request,String role,int id);
    void giveTokenToBrowser(HttpServletResponse response,Token token);
    String getTokenUUIDFromCookie(Cookie request);

}
