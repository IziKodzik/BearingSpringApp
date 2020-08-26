package service.implementation;

import dao.ClientDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.ClientService;

@Service("fakeClientService")
public class FakeClientServiceImpl
    implements ClientService {

    private final ClientDao clientDao;

    @Autowired
    public FakeClientServiceImpl(@Qualifier("fakeDao") ClientDao clientDao){
        this.clientDao = clientDao;
    }

    @Override
    public User getUserById(int id) {
        return clientDao.getUserById(id);
    }
}
