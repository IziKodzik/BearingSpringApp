import model.User;

import java.util.LinkedHashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {

        Set<User> userSet = new LinkedHashSet<User>();
        userSet.add(new User(0,"Pap","Pap",null));
        userSet.add(new User(1,"XD","GG",null));
        System.out.println(userSet);

    }

}
