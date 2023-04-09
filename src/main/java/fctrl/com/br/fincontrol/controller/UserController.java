package fctrl.com.br.fincontrol.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fctrl.com.br.fincontrol.model.User;
import fctrl.com.br.fincontrol.repository.UserRepository;
import fctrl.com.br.fincontrol.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Valid
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    
    private final UserService userService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public User save(@RequestBody @Valid User user) {
        return userService.save(user);
    }
}
