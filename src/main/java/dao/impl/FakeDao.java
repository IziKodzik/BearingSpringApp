package dao.impl;
import dao.UsersDao;
import model.Role;
import model.User;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository("fakeDao")
public class FakeDao
    implements UsersDao {

    final Map<String,User> clients = new LinkedHashMap();
    final Map<String,Role> roles = new LinkedHashMap<>();

    public FakeDao(){
        this.generateFakeClients();
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {

        return clients.get(username);
    }

    public void generateFakeClients(){


        if(roles.size()==0){
            roles.put("ADMIN",new Role(0,"ADMIN"));
            roles.put("USER",new Role(1,"USER"));
        }
        if (clients.size()==0){


            clients.put("Jan",new User(0,"Jan","Pawel",null));
            clients.put("Tomasz",new User(1,"Tomasz","Hajto",null));
            clients.put("Karol",new User(2,"Karol","Wojtyla",null));

        }
        System.out.println(clients);
        System.out.println("XDD");

    }
}
