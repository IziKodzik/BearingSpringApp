package service.implementation;

import dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.UserService;

@Service("fakeUserService")
public class FakeUserServiceImpl
    implements UserService {

    private final UsersDao usersDao;

    @Autowired
    public FakeUserServiceImpl(@Qualifier("fakeDao") UsersDao usersDao){
        this.usersDao = usersDao;
    }


    @Override
    public void askForCalculation() {
        System.out.println("calc");
    }
}
