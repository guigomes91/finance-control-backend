package fctrl.com.br.fincontrol.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fctrl.com.br.fincontrol.model.User;

public interface UserService {
    
    User save(User user);

    Page<User> list(Pageable page);
}
