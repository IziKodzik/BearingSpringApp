package service;

import model.Token;
import org.springframework.web.servlet.ModelAndView;

public interface GuestService {

    ModelAndView redirect(Token token);

}
