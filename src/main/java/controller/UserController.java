package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.SecurityService;
import service.UserService;

import javax.servlet.http.Cookie;

@Controller
@RequestMapping("/user")
public class UserController {


    final UserService userService;
    final SecurityService securityService;

    @Autowired
    public UserController(@Qualifier("fakeUserService") UserService userService, SecurityService securityService){
        this.userService = userService;
        this.securityService = securityService;
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ModelAndView home(@PathVariable int id,
                             @CookieValue(value = "bearing_token",defaultValue = "empty") String cookie){

       if(!(securityService
                .hasRoleAndId(securityService.getTokenUUIDFromCookie(cookie), "USER", id))) {
           System.out.println("TO DO REDIRECT");
       }
        ModelAndView mav = new ModelAndView("user-home");
        mav.addObject("id",id);
        return mav;
    }


    @GetMapping("/account")
    public ModelAndView displayAccount(){

        ModelAndView mav = new ModelAndView("account");
        return mav;

    }


}
