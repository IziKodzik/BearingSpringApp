package service;

import model.User;

public interface SecurityService {

    String authenticateUser(User user);

    String redirect(String key);

}
