package service;

import model.Role;
import model.Token;
import model.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.Set;

public interface SecurityService {

    Token authenticateUser(User user);
    String redirectv0(Token token);
    Set<Role> parseTokenToRoles(Token token);
    User parseTokenToUser(Token token);
    boolean hasRole(Token token, String... roles);
    boolean hasId(Token token,int id);
    boolean hasRoleAndId(Token token,int id,String... roles);
    void giveTokenToBrowser(HttpServletResponse response,Token token);
    Token getTokenUUIDFromCookie(String request);
    ModelAndView noAuthRedirect(final RedirectAttributes redirectAttributes);

}
