package service.implementation;

import dao.UsersDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.SecurityService;

@Service("SecurityService")
public class SecurityServiceImpl
    implements SecurityService {

    private final UsersDao DB;

    @Autowired
    public SecurityServiceImpl(@Qualifier("fakeDao") UsersDao DB) {
        this.DB = DB;
    }

    @Override
    public String authenticateUser(User user) {

        User logger = DB.getUserByUsername(user.getUsername());
        if(logger==null)
            return "Failed not exists.";
        if(user.getPassword().equals(logger.getPassword()))
            return "Cool";
        else
            return "Failed";

    }

    @Override
    public String redirect(String key) {
        return null;
    }
}
