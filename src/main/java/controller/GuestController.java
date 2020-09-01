package controller;

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
import service.SecurityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class GuestController {

    private final SecurityService securityService;

    @Autowired
    public GuestController(@Qualifier("SecurityService") SecurityService securityService) {
        this.securityService = securityService;
    }


//    @GetMapping("/testSend")
//    public ModelAndView test(final RedirectAttributes redirectAttributes) {
//        // the following attribute is a ModelAttribute
//        redirectAttributes.addFlashAttribute("auth", true);
//        final ModelAndView redirectView = new ModelAndView("redirect:/");
//        return redirectView;
//    }
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
            ,@ModelAttribute("auth") final String auth
        ,HttpServletRequest request) {

        System.out.println(auth + " <---");
        ModelAndView mav = new ModelAndView("guest-login");
        if(auth.equals("F"))
            mav.addObject("badLogin","No authorization");

        User user = new User();
        model.addAttribute("user",user);

        return mav;

    }
    @PostMapping("/processLogin")
    public ModelAndView processLogin (final RedirectAttributes redirectAttributes
        ,@ModelAttribute("user") User user,final Model model
            ,HttpServletResponse response){


        Token token = securityService.authenticateUser(user);
           String redirect = securityService.redirectv0(token);

           return new ModelAndView(String.format("redirect:%s", redirect));

    }

}
