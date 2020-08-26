package dao.impl;
import dao.UserDao;
import model.User;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository("fakeDao")
public class FakeDao
    implements UserDao {

    final Set<User> clients = new LinkedHashSet<User>();

    public FakeDao(){
        this.generateFakeClients();
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    public void generateFakeClients(){

        if (clients.size()==0){
            clients.add(new User(0,"Jan","Pawel",null));
            clients.add(new User(1,"Tomasz","Hajto",null));
            clients.add(new User(2,"Karol","Wojtyla",null));

        }
        System.out.println(clients);
        System.out.println("XDD");

    }
}
