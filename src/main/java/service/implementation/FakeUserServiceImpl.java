package service.implementation;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.UserService;

@Service("fakeUserService")
public class FakeUserServiceImpl
    implements UserService {

    private final UserDao userDao;

    @Autowired
    public FakeUserServiceImpl(@Qualifier("fakeDao") UserDao userDao){
        this.userDao = userDao;
    }


    @Override
    public void askForCalculation() {
        System.out.println("calc");
    }
}
