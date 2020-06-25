package heroesproject.demo.service;

import heroesproject.demo.models.entity.User;
import heroesproject.demo.models.service.UserServiceModel;
import heroesproject.demo.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public void register(UserServiceModel userServiceModel) {
        this.userRepository.saveAndFlush(this.modelMapper
        .map(userServiceModel, User.class));
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        return this.userRepository.findByUsername(username)
                .map(user ->
                   this.modelMapper.map(user, UserServiceModel.class)
                ).orElse(null);
    }
}
