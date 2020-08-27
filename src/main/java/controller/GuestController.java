package controller;

import model.Token;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.SecurityService;

@Controller
public class GuestController {

    private final SecurityService securityService;

    @Autowired
    public GuestController(@Qualifier("SecurityService") SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping
    public ModelAndView displayLogin(Model model) {

        User user = new User();
        model.addAttribute("user",user);
        ModelAndView mav = new ModelAndView("guest-login");

        return mav;

    }
    @PostMapping("/processLogin")
    public ModelAndView processLogin(@ModelAttribute("user") User user, Model model){

           Token token = securityService.authenticateUser(user);
           String redirect = securityService.redirect(token);
           if(redirect.equals("/"))
               model.addAttribute("badLogin","Not authorized");


           return new ModelAndView(String.format("redirect:%s", redirect));

    }




}
