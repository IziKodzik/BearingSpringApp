package dao.impl;
import dao.ClientDao;
import model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository("fakeDao")
public class FakeDao
    implements ClientDao {

    final List<User> clients = new ArrayList<User>();

    public FakeDao(){
        this.generateFakeClients();
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    public void generateFakeClients(){

        if (clients.size()!=0){
            clients.add(new User(0,"Jan","Pawel",null));
            clients.add(new User(1,"Tomasz","Hajto",null));
            clients.add(new User(2,"Karol","Wojtyla",null));

        }

    }
}
