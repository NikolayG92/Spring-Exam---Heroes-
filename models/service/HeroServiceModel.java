package heroesproject.demo.models.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class HeroServiceModel extends BaseServiceModel{

    private String name;
    private String className;
    private int level;
}
