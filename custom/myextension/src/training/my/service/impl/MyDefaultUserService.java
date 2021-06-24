package training.my.service.impl;

import training.my.repository.UserRepository;
import training.my.service.MyUserService;

public class MyDefaultUserService implements MyUserService {

    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public int getNumberOfUsers() {
        return userRepository.findTotalNumber();
    }
}