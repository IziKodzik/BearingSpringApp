package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {


    final UserService userService;

    @Autowired
    public UserController(@Qualifier("fakeUserService") UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ModelAndView home(@PathVariable int id){



        System.out.println(id);
        ModelAndView mav = new ModelAndView("user-home");
        mav.addObject("id","jotde");
        return mav;
    }


    @GetMapping("/account")
    public ModelAndView displayAccount(){

        ModelAndView mav = new ModelAndView("account");
        return mav;

    }


}
