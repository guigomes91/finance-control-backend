package fctrl.com.br.fincontrol.controller;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fctrl.com.br.fincontrol.model.Account;
import fctrl.com.br.fincontrol.model.enumerations.EAccountStatus;
import fctrl.com.br.fincontrol.service.AccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@Valid
@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {
    
    private final AccountService accountService;

    @GetMapping(produces = "application/json")
    public Page<Account> list(@Valid @NotNull Pageable page) {
        return accountService.list(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> listById(@PathVariable @NotNull UUID id) {
        Account acount = accountService.listById(id);

        if (!Objects.isNull(acount)) {
            return ResponseEntity.ok().body(acount);
        }

        return ResponseEntity.notFound().build();       
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(produces = "application/json")
    public Account save(@RequestBody @Valid Account acc) {
        return accountService.save(acc);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> update(@PathVariable @NotNull UUID id, 
        @RequestBody @Valid Account acc) {

        Account accountSaved = accountService.update(acc, id);
        if (!Objects.isNull(accountSaved)) {
            return ResponseEntity.ok().body(accountSaved);
        }
        
        return ResponseEntity.notFound().build();
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping
    public void delete(UUID id) {
        accountService.delete(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/situacao")
    public List<Account> findBySituacao(@RequestParam("situacao") EAccountStatus sit) {
        return accountService.findBySituacao(sit);
    }
}
