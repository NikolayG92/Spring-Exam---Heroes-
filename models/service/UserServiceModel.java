package heroesproject.demo.models.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserServiceModel extends BaseServiceModel{

    private String username;
    private String password;
    private String email;
    private String country;
}
