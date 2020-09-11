package controller;


import model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.SecurityService;
import service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {


    final UserService userService;
    final SecurityService securityService;

    @Autowired
    public UserController(@Qualifier("fakeUserService") UserService userService
              , SecurityService securityService){
        this.userService = userService;
        this.securityService = securityService;
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ModelAndView home(@PathVariable int id,
                             @CookieValue(value = "bearing_token"
                                     ,defaultValue = "empty") String cookie
                            , RedirectAttributes attributes,HttpServletRequest request
                            , @ModelAttribute("from") String from){

        System.out.println(from + " controller");

        Token token =  securityService.getTokenUUIDFromCookie(cookie);
       if(!(securityService
                .hasRoleAndId(
                       token, id, "USER","ADMIN"))) {
           return securityService.noAuthRedirect(attributes,
                   from,request.getRequestURL().toString());
       }
        ModelAndView mav = new ModelAndView("user-home");
        mav.addObject("id",token.getUser().getUsername() );
        return mav;
    }

    @PostMapping("/calculate")
    public ModelAndView calculate(@RequestParam("type-of-service") String typeOfService
            ,@RequestParam("grade-of-thordon") String gradeOfThordon
            , RedirectAttributes attributes
        ,@CookieValue(value = "bearing_token",defaultValue = "empty") String cookie
            ,HttpServletRequest request,
                                  @ModelAttribute("from") String from) {

        if (!securityService
                .hasRole(securityService.getTokenUUIDFromCookie(cookie), "USER", "ADMIN"))
            return securityService.noAuthRedirect(attributes,from,request.getRequestURL().toString());

        return new ModelAndView("test");

    }

    @GetMapping("/{id}/account")
    public ModelAndView displayAccount(@PathVariable int id,
                                        @CookieValue(value ="bearing_token",defaultValue = "empty") String cookie,
                                       RedirectAttributes attributes,@ModelAttribute("from") String fromAttrib,
                                       HttpServletRequest request){
        if(!(securityService.hasRoleAndId(securityService.getTokenUUIDFromCookie(cookie), id, "USER")))
            return securityService.noAuthRedirect(attributes,fromAttrib,request.getRequestURL().toString());

        ModelAndView mav = new ModelAndView("user-account");
        return mav;

    }


}
