package service.implementation;

import dao.UsersDao;
import model.Role;
import model.Token;
import model.User;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.SecurityService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Service("SecurityService")
public class SecurityServiceImpl
    implements SecurityService {

    private final UsersDao DB;

    @Autowired
    public SecurityServiceImpl(@Qualifier("fakeDao") UsersDao DB) {
        this.DB = DB;
    }

    @Override
    public Token authenticateUser(User logger) {

        Optional<User> maybeClient = DB.getUserByUsername(logger.getUsername());
        if(!(maybeClient.isPresent()))
            return null;
        User client = maybeClient.get();
        if(logger.getPassword().equals(client.getPassword())) {

            Optional<Token> userToken = DB.getTokenByUserName(client.getUsername());
            boolean isPresent = userToken.isPresent();
            boolean isExpired;

            if(isPresent){
                isExpired = userToken.get().isExpired();

                if(!isExpired) {
                    System.out.println("Refreshed");
                    DB.refreshToken(userToken.get());
                    return userToken.get();
                }else {
                    System.out.println("Depricated");
                    DB.deleteToken(userToken.get());
                }
            }
            Optional<User> suspect;
            do {
                userToken = (Optional.of(new Token(UUID.randomUUID())));
                suspect = DB.getUserByUsername(client.getUsername());
            }while (!(suspect.isPresent()));
            userToken.get().setExpireDate(DateTime.now().plusHours(1));
            DB.addTokenForUser(client,userToken.get());


            System.out.println(DB.getUsers() + " <-- users updated");
            System.out.println(DB.getTokens());
            return userToken.get();
        }
        return null;

    }

    @Override
    public User parseTokenToUser(Token token) {
        Optional<Token> maybeToken = DB.getToken(token);
        if(maybeToken.isPresent())
            return token.getUser();
        return null;
    }

    @Override
    public Set<Role> parseTokenToRoles(Token token) {
        User user = parseTokenToUser(token);
        if(user!=null)
            return user.getRoles();
        return null;
    }

    @Override
    public String redirectv0(Token token) {
        if(token==null || token.isExpired())
            return "/";

        User user = parseTokenToUser(token);
        Set<Role> roles = user.getRoles();
        if(roles==null || roles.size()==0)
            return "/";

        Iterator<Role> roleIterator = roles.iterator();
        if(roleIterator.next().getName().equals("ADMIN"))
            return String.format("/admin/%d",user.getId());
        return String.format("/user/%d",user.getId());

    }

    @Override
    public void giveTokenToBrowser(HttpServletResponse response, Token token) {
        if(token!=null)
            response.addCookie(new Cookie("bearing_token",token.getId().toString()));
    }

    @Override
    public boolean hasRole(Token token, String... roles) {

        return (token != null && !token.isExpired() && this.hasRole(token.getUser(),roles));


    }
    @Override
    public boolean hasId(Token token, int id) {
        return (token!=null&&  !token.isExpired() && this.hasId(token.getUser(),id) );

    }

    @Override
    public boolean hasRole(User user, String... roles) {
        return user != null &&
                Arrays.stream(roles).anyMatch(role->user.getRoles().contains(new Role(role)));
    }

    @Override
    public boolean hasId(User user, int id) {
        return user != null && user.getId()==id;
    }

    @Override
    public boolean hasRoleAndId(User user, int id, String... roles) {
        return hasId(user,id) && hasRole(user,roles);
    }

    @Override
    public Token getTokenUUIDFromCookie(String cookie) {
        return DB.getTokenByUUID(cookie).orElse(null);
    }

    @Override
    public ModelAndView noAuthRedirect(final RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("auth","F");
        return new ModelAndView("redirect:/");

    }

    @Override
    public boolean hasRoleAndId(Token token, int id, String... roles) {
        return hasRole(token,roles) && hasId(token,id);
    }

}
