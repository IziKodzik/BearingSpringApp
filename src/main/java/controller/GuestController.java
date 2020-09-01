package controller;

import model.Token;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.SecurityService;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class GuestController {

    private final SecurityService securityService;

    @Autowired
    public GuestController(@Qualifier("SecurityService") SecurityService securityService) {
        this.securityService = securityService;
    }


//    @GetMapping("/test")
//    public ModelAndView test(HttpServletRequest request, HttpServletResponse response,
//                             @CookieValue(value = "test",defaultValue = "-00=")String cookie){
//
//
//        return new ModelAndView("test");
//    }

    @GetMapping
    public ModelAndView displayLogin(Model model,HttpServletRequest request) {


        ModelAndView mav = new ModelAndView("guest-login");


            mav.addObject("badLogin", "Not yet");

        User user = new User();
        model.addAttribute("user",user);

        return mav;

    }
    @PostMapping("/processLogin")
    public ModelAndView processLogin(@ModelAttribute("user") User user, Model model,
                                    HttpServletResponse response){


           Token token = securityService.authenticateUser(user);
           String redirect = securityService.redirect(token);
           if(redirect.equals("/")) {
               //wymyśl cos lepszego 
//               ModelAndView mav = new ModelAndView("guest-login");
//
//
//               mav.addObject("badLogin", "No authorization");
//
//               User usere = new User();
//               model.addAttribute("user",usere);
//
//               return mav;
           }else
               securityService.giveTokenToBrowser(response,token);
        return new ModelAndView(String.format("redirect:%s", redirect));

    }




}
