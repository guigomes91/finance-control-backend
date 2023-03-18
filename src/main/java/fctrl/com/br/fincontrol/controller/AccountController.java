package fctrl.com.br.fincontrol.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fctrl.com.br.fincontrol.model.Account;
import fctrl.com.br.fincontrol.repository.AccountRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {
    
    private final AccountRepository repository;

    @GetMapping
    public List<Account> getAccount() {
        return repository.findAll();
    }
}
