package heroesproject.demo.service;

import heroesproject.demo.models.entity.Hero;
import heroesproject.demo.models.service.HeroServiceModel;
import heroesproject.demo.models.view.HeroViewModel;
import heroesproject.demo.repositories.HeroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroServiceImpl implements HeroService {
    private final HeroRepository heroRepository;
    private final ModelMapper modelMapper;

    public HeroServiceImpl(HeroRepository heroRepository, ModelMapper modelMapper) {
        this.heroRepository = heroRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<HeroViewModel> findAllHeroes() {
        return this.heroRepository.findAll()
                .stream()
                .map(hero -> {
                    HeroViewModel heroViewModel = this.modelMapper
                            .map(hero, HeroViewModel.class);
                    heroViewModel.setImageUrl(String.format
                            ("/img/%s.jpg", hero.getClassName()));
                    return heroViewModel;
                }).collect(Collectors.toList());
    }

    @Override
    public void addHero(HeroServiceModel heroServiceModel) {
        this.heroRepository.saveAndFlush(this.modelMapper
        .map(heroServiceModel, Hero.class));
    }

    @Override
    public Hero findById(String id) {

        return this.heroRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        this.heroRepository.delete
                (this.heroRepository.findById(id).orElse(null));
    }
}
