package fctrl.com.br.fincontrol.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fctrl.com.br.fincontrol.model.Account;

@RestController
public class AccountController {
    
    @GetMapping
    public List<Account> getAccount() {
        return List.of();
    }
}
