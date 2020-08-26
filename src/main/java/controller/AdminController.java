package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.ClientService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController
    extends UserController{

    private final ClientService clientService;

    @Autowired
    public AdminController(@Qualifier("fakeClientService") ClientService clientService) {
        this.clientService = clientService;
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
