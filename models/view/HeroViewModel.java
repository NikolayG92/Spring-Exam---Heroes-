package heroesproject.demo.models.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class HeroViewModel {

    private String id;
    private String name;
    private String className;
    private int level;
    private String imageUrl;
}
