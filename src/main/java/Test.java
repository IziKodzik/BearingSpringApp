import model.Token;
import model.User;
import org.joda.time.DateTime;
import org.joda.time.Period;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class Test {

    public static void main(String[] args) {

        User user = new User(0,"Jaroslaw","Komcur",null);

        Token token = user.getToken();
        token = new Token(UUID.randomUUID(),DateTime.now());
        Optional<User> usero = Optional.of(user);
        System.out.println(usero.get().getToken());


    }

}
