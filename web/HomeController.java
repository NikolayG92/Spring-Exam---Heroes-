package heroesproject.demo.web;

import heroesproject.demo.service.HeroService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final HeroService heroService;

    public HomeController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/")
    public ModelAndView index(HttpSession httpSession, ModelAndView modelAndView){
        if(httpSession.getAttribute("user") == null){
            modelAndView.setViewName("index");
        }else{
            modelAndView.addObject("heroes", this.heroService.findAllHeroes());
            modelAndView.setViewName("home");
        }
        return modelAndView;
    }
}
