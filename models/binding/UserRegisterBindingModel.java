package heroesproject.demo.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class UserRegisterBindingModel {

    @Length(min = 3, message = "Username length must be at least 3 characters!")
    private String username;
    @Email
    private String email;
    @Length(min = 3, message = "Password length must be at least 3 characters!")
    private String password;
    private String confirmPassword;
    @NotNull
    private String country;
}
