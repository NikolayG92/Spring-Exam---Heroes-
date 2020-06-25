package heroesproject.demo.service;

import heroesproject.demo.models.entity.Hero;
import heroesproject.demo.models.service.HeroServiceModel;
import heroesproject.demo.models.view.HeroViewModel;

import java.util.List;

public interface HeroService {
    List<HeroViewModel> findAllHeroes();

    void addHero(HeroServiceModel map);

    Hero findById(String id);

    void delete(String id);
}
