package fctrl.com.br.fincontrol.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    @Override
    public Page<User> list(Pageable page) {
        return userRepository.findAll(page);
    }
    
}
