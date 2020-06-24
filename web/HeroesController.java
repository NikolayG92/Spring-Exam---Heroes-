package heroesproject.demo.web;

import heroesproject.demo.models.binding.HeroAddBindingModel;
import heroesproject.demo.models.entity.Hero;
import heroesproject.demo.models.service.HeroServiceModel;
import heroesproject.demo.repositories.HeroRepository;
import heroesproject.demo.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/heroes")
public class HeroesController {

    private final HeroService heroService;
    private final ModelMapper modelMapper;

    public HeroesController(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/create")
    public String getCreate(Model model){
        if(!model.containsAttribute("heroAddBindingModel")){
            model.addAttribute("heroAddBindingModel", new HeroAddBindingModel());
        }
        return "create-hero";
    }

    @PostMapping("/create")
    public String createConfirm(@Valid @ModelAttribute("heroAddBindingModel")
                                HeroAddBindingModel heroAddBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("heroAddBindingModel", heroAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.heroAddBindingModel", bindingResult);
            return "redirect:create";
        }

        HeroServiceModel hero = this.modelMapper.map(heroAddBindingModel, HeroServiceModel.class);
        hero.setClassName(heroAddBindingModel.getHeroClass());
        this.heroService.addHero
               (hero);

        return "redirect:/";
    }

    @GetMapping("/details")
    public ModelAndView details(@RequestParam("id") String id, ModelAndView modelAndView){

        modelAndView.addObject("hero", this.heroService.findById(id));
        modelAndView.setViewName("details-hero");

        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        this.heroService.delete(id);

        return "redirect:/";
    }

}
