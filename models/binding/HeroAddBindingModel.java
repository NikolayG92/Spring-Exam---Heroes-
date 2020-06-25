package heroesproject.demo.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class HeroAddBindingModel {

    @Length(min = 3, message = "Name length must be at least 3 characters!")
    private String heroName;
    @NotNull
    private String heroClass;
    @Min(value = 1, message = "Min level is 1!")
    private int level;
}
