import model.Token;
import model.User;
import org.joda.time.DateTime;
import org.joda.time.Period;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        User user = new User(0,"Jaroslaw","Komcur",null);
        User user1 = new User(1,"Jaroslaw","Pies",null);
        HashSet<User> users = new HashSet<>();
        users.add(user);
        users.add(user1);
        System.out.println(users.size());
    }

}
