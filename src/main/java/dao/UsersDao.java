package dao;


import model.User;

public interface UsersDao {

    User getUserById(int id);
    User getUserByUsername(String username);

}
