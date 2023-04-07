package fctrl.com.br.fincontrol.controller;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

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
import fctrl.com.br.fincontrol.repository.AccountRepository;
import fctrl.com.br.fincontrol.service.AccountServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@Valid
@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {
    
    private final AccountRepository repository;
    private final AccountServiceImpl accountService;

    @GetMapping(produces = "application/json")
    public List<Account> list() {
        return accountService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> listById(@PathVariable @NotNull UUID id) {
        return repository.findById(id)
            .map(acc -> ResponseEntity.ok().body(acc))
            .orElse(ResponseEntity.notFound().build());
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(produces = "application/json")
    public Account save(@RequestBody @Valid Account acc) {
        return repository.save(acc);
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
        Account acDelete = repository.findById(id).orElseThrow();
        repository.delete(acDelete);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/find")
    public List<Account> findByFiltroSituacao(@RequestParam("filtro") EAccountStatus filtro) {
        return repository.findByStatus(filtro);
    }
}
