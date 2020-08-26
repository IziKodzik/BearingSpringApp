package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "{id}/home",method = RequestMethod.GET)
    public ModelAndView home(@PathVariable int id){


        System.out.println(id);
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
