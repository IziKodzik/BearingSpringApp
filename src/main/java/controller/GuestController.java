package controller;

import model.DTOs.Request.LoginForm;
import model.Token;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import service.GuestService;
import service.SecurityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class GuestController {

    private final SecurityService securityService;
    private final GuestService guestService;

    @Autowired
    public GuestController(@Qualifier("SecurityService") SecurityService securityService,
                           @Qualifier("guestService") GuestService guestService) {
        this.securityService = securityService;
        this.guestService = guestService;
    }


    @GetMapping("/test")
    public ModelAndView test(final RedirectAttributes redirectAttributes) {
        // the following attribute is a ModelAttribute

        return new ModelAndView("test");
    }
//    @GetMapping("/testRecive")
//    public ModelAndView redirectedPage(
//            // access FlashAttributes
//            final Model model, @ModelAttribute("auth") final String messageA,
//            // access 'dynamic' Attributes
//            @RequestParam("messageB") final String messageB, @RequestParam("messageC") final String messageC) {
//
//        System.out.println(messageA);
//
//        return new ModelAndView("admin-home");
//    }

    @RequestMapping(method = {RequestMethod.GET})
    public ModelAndView displayLogin(final ModelMap model
            ,@ModelAttribute("from") final String from) {

        ModelAndView mav = new ModelAndView("guest-login");
        if(!(from.isEmpty())) {
            if(from.equals("F")) {
                mav.addObject("from", "");
                mav.addObject("badLogin", "You could not continue session");
            }else {
                if(from.contains("notAuthenticated"))
                    mav.addObject("from","");
                else
                    mav.addObject("from", from);
                mav.addObject("badLogin", "No authorization");
            }
        }

        LoginForm form = new LoginForm();
        model.addAttribute("login-form",form);

        return mav;

    }
    @PostMapping("/processLogin")
    public ModelAndView processLogin (final RedirectAttributes redirectAttributes
        ,@ModelAttribute("login-form") LoginForm form,final Model model
            ,HttpServletResponse response){

        User user = new User(form.getUsername(),form.getPassword());
        Token token = securityService.authenticateUser(user);
        securityService.giveTokenToBrowser(response,token);
        redirectAttributes.addFlashAttribute("from",form.getFrom());

        return guestService.redirect(token,form.getFrom());

    }

    @GetMapping("/notAuthenticated")
    public ModelAndView notAuthenticated(RedirectAttributes attributes,
                                         HttpServletRequest request,
                                            @ModelAttribute("from") String from){
            return securityService.noAuthRedirect(attributes,from,request.getRequestURL().toString());
    }

}
