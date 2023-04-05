package fctrl.com.br.fincontrol.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fctrl.com.br.fincontrol.model.AccountPlan;
import fctrl.com.br.fincontrol.repository.AccountPlanRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/account_plan")
public class AccountPlanController {
    
    private AccountPlanRepository repository;

    @GetMapping
    public List<AccountPlan> list() {
        return repository.findAll();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(produces = "application/json")
    public AccountPlan save(@RequestBody AccountPlan accountPlan) {
        return repository.save(accountPlan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountPlan> update(@PathVariable @NotNull UUID id, 
        @RequestBody @Valid AccountPlan accountPlan) {
        return repository.findById(id)
            .map(recordFound -> {
                recordFound.setName(accountPlan.getName());
                recordFound.setType(accountPlan.getType());
                AccountPlan updated = repository.save(recordFound);
                return ResponseEntity.ok().body(updated);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping
    public void delete(UUID id) {
        AccountPlan accountPlan = repository.findById(id).orElseThrow();
        repository.delete(accountPlan);
    }
}
