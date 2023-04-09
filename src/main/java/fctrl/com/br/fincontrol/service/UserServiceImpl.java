package fctrl.com.br.fincontrol.service;

import java.util.UUID;

import fctrl.com.br.fincontrol.model.User;
import fctrl.com.br.fincontrol.repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
    
}
