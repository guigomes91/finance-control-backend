package fctrl.com.br.fincontrol.controller;

import java.util.Objects;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fctrl.com.br.fincontrol.model.User;
import fctrl.com.br.fincontrol.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable @NotNull UUID id, 
        @RequestBody @Valid User user) {

        User userSaved = userService.update(user, id);
        if (!Objects.isNull(userSaved)) {
            return ResponseEntity.ok().body(userSaved);
        }
        
        return ResponseEntity.notFound().build();
    }

    @GetMapping(produces = "application/json")
    public Page<User> list(@Valid @NotNull Pageable page) {
        return userService.list(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> listById(@PathVariable @NotNull UUID id) {
        User user = userService.listById(id);

        if (!Objects.isNull(user)) {
            return ResponseEntity.ok().body(user);
        }

        return ResponseEntity.notFound().build();       
    }
}
