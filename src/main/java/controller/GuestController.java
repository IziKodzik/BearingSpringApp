package controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GuestController {

    @GetMapping
    public ModelAndView displayLogin(Model model) {

        User user = new User();
        model.addAttribute("user",user);
        ModelAndView mav = new ModelAndView("guest-login");

        return mav;

    }
    @PostMapping("/processLogin")
    public String processLogin(@ModelAttribute("user") User user, Model model){

        System.out.println(user.getName());
        System.out.println("XDDD");


//        return "redirect:/user/login";
        return "redirect:/jdokra";

    }




}
