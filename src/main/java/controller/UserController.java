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

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.ImageView;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("{id}/test")
    public ModelAndView test(@PathVariable int id,@RequestParam("jd") int jd,
                             @CookieValue(value = "bearing_token",defaultValue = "empty") String cookie,
                             @ModelAttribute("from") String from,HttpServletRequest request,
                             RedirectAttributes attributes){
        if(!securityService.hasRoleAndId(securityService.getTokenUUIDFromCookie(cookie),id,"USER"))
            return securityService.noAuthRedirect(attributes,request.getRequestURL().toString(),from);
        System.out.println(jd);
        return new ModelAndView("test");
    }

    @GetMapping("/{id}/account")
    public ModelAndView displayAccount(@PathVariable int id,
                                        @CookieValue(value ="bearing_token",
                                                defaultValue = "empty") String cookie,
                                       RedirectAttributes attributes,
                                       @ModelAttribute("from") String fromAttrib,
                                       HttpServletRequest request){
        if(!(securityService.hasRoleAndId(securityService.getTokenUUIDFromCookie(cookie), id, "USER")))
            return securityService
                    .noAuthRedirect(attributes,fromAttrib,request.getRequestURL().toString());

        ModelAndView mav = new ModelAndView("user-account");
        return mav;

    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
//        response.addCookie(new Cookie("bearing_token",token.getId().toString()));

        securityService.logout(request,response);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("{id}/app")
    public ModelAndView openApp(@PathVariable int id,
								@ModelAttribute("view") String view,
								RedirectAttributes attributes){

        ModelAndView mav = new ModelAndView("user-application");
        if(view.isEmpty()){
			try {
				view = createColorMap(this.userService.loadAppView(id)).toString();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        mav.addObject("appView",view);

		return mav;
    }

    @PostMapping("{id}/app/click")
    public ModelAndView click(@PathVariable int id,
                              @RequestParam("x") int x,
                              @RequestParam("y") int y,
                              RedirectAttributes attributes){

        System.out.println(x + " " + y);
        try {
            attributes.addFlashAttribute("view",
                 createColorMap(userService.click(id, x, y)));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView(String.format(("redirect:/user/%d/app"),id));

    }
	@PostMapping("{id}/app/fill")
	public ModelAndView clickThenFill(@PathVariable int id,
							  @RequestParam("x") int x,
							  @RequestParam("y") int y,
							  @RequestParam("command") String command,
							  RedirectAttributes attributes){

		try {
			attributes.addFlashAttribute("view",
					createColorMap(userService.clickThenFill(id, x, y,command)));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView(String.format(("redirect:/user/%d/app"),id));

	}


	@GetMapping("/test")
	public ModelAndView test(){
		return new ModelAndView("test");
	}



	private StringBuffer createColorMap(BufferedImage bufferedImage){

		StringBuffer result = new StringBuffer();
        for(int op = 0 ; op < bufferedImage.getHeight() ; ++ op){
            for(int po = 0 ; po < bufferedImage.getWidth(); ++ po){
                int color = bufferedImage.getRGB(po,op);
                result.append(color).append(",");

            }
        }
        return result;
    }


}
