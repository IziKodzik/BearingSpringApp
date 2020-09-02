package service.implementation;

import model.Token;
import model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import service.GuestService;

import static java.lang.String.format;

@Service("guestService")
public class GuestServiceImpl
    implements GuestService {


    @Override
    public ModelAndView redirect(Token token) {
        if(token == null)
            return new ModelAndView("redirect:/notAuthenticated");
        User user = token.getUser();
        return new ModelAndView(format(("redirect:/%s/%d"),"USER".toLowerCase(),user.getId()));
    }
}
