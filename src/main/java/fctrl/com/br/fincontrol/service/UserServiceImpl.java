package fctrl.com.br.fincontrol.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fctrl.com.br.fincontrol.model.User;
import fctrl.com.br.fincontrol.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public Page<User> list(Pageable page) {
        return userRepository.findAll(page);
    }

    @Transactional
    @Override
    public User listById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public User update(User user, UUID id) {
        return userRepository.findById(id)
            .map(recordFound -> {
                recordFound.setLogin(user.getLogin());
                recordFound.setName(user.getName());
                recordFound.setUserChanged(user);
                recordFound.setDateTimeChanged(new Date());

                return userRepository.save(recordFound);
            })
            .orElse(null);
    }

    @Override
    public void delete(UUID id) throws Exception {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new Exception("Registro não existe!");
        }
    }
}
