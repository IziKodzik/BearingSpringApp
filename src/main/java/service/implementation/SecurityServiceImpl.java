package service.implementation;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.SecurityService;

@Service
public class SecurityServiceImpl
    implements SecurityService {

    private final UserDao DB;

    @Autowired
    public SecurityServiceImpl(@Qualifier("fakeDao") UserDao DB) {
        this.DB = DB;
    }

    @Override
    public String authenticateUser(String username, String password) {


        return null;
    }
}
