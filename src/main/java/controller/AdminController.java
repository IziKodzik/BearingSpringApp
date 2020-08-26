package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController{

    private final UserService userService;

    @Autowired
    public AdminController(@Qualifier("fakeUserService") UserService userService) {
        this.userService = userService;
    }
//
//    @RequestMapping(value = "/showUser/{id}",method = RequestMethod.GET)
//    public ModelAndView getUserById(@PathVariable int id){
//        User user = clientService.getUserById(id);
//
//    }


    @GetMapping("/{id}/home")
    public ModelAndView home(@PathVariable int id) {
        return new ModelAndView("admin-home");
    }
}
