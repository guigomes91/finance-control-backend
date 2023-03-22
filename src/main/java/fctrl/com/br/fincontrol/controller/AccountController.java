package fctrl.com.br.fincontrol.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fctrl.com.br.fincontrol.model.Account;
import fctrl.com.br.fincontrol.model.enumerations.EAccountStatus;
import fctrl.com.br.fincontrol.repository.AccountRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {
    
    private final AccountRepository repository;

    @GetMapping(produces = "application/json")
    public List<Account> list() {
        return repository.findAll();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(produces = "application/json")
    public Account save(@RequestBody @Valid Account acc) {
        return repository.save(acc);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping
    public void delete(UUID id) {
        Account acDelete = repository.findById(id).orElseThrow();
        repository.delete(acDelete);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/find")
    public List<Account> findByFiltroSituacao(@RequestParam("filtro") EAccountStatus filtro) {
        return repository.findByStatus(filtro);
    }
}
