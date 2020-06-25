package heroesproject.demo.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@Getter
@Setter
public class UserLoginBindingModel {

    @Length(min = 3, message = "Username length must be at least 3 characters!")
    private String username;
    @Length(min = 3, message = "Password length must be at least 3 characters!")
    private String password;
}
