package heroesproject.demo.service;

import heroesproject.demo.models.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel map);

    UserServiceModel findByUsername(String username);
}
