package service.implementation;

import dao.UsersDao;
import model.Role;
import model.Token;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.SecurityService;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

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
            if(!(userToken.isPresent())){
                Optional<User> suspect;
                do {
                    userToken = (Optional.of(new Token(UUID.randomUUID())));
                    suspect = DB.getUserByUsername(client.getUsername());
                }while (!(suspect.isPresent()));

                DB.addTokenForUser(client,userToken.get());
            }
            return userToken.get();
        }
        return null;

    }

    @Override
    public Set<Role> parseToken(Token token) {
        Optional<Token> maybeToken = DB.getToken(token);
        if (maybeToken.isPresent()) {
            Token t = maybeToken.get();
            return t.getUser().getRoles();
        }
        return null;
    }

    @Override
    public String redirect(Token token) {
        if(token==null || token.isExpired())
            return "/";

        Set<Role> roles = parseToken(token);
        if(roles==null || roles.size()==0)
            return "/";

//        if(roles.stream().filter())
        return "/";

    }


}
