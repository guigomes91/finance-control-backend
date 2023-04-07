package fctrl.com.br.fincontrol.service;

import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import fctrl.com.br.fincontrol.model.Account;
import fctrl.com.br.fincontrol.model.enumerations.EAccountStatus;
import fctrl.com.br.fincontrol.repository.AccountRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Transactional
    @Override
    public Account update(Account acc, UUID id) {
        return repository.findById(id)
            .map(recordFound -> {
                recordFound.setDescription(acc.getDescription());
                recordFound.setDue(acc.getDue());
                recordFound.setPayment(acc.getPayment());
                recordFound.setAmount(acc.getAmount());
                recordFound.setPortion(acc.getPortion());
                recordFound.setType(acc.getType());
                recordFound.setStatus(acc.getStatus());

                return repository.save(recordFound);
            })
            .orElse(null);
    }

    @Transactional
    @Override
    public List<Account> list() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Account listById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Account save(Account acc) {
        return repository.save(acc);
    }

    @Override
    public void delete(UUID id) {
        Account acDelete = repository.findById(id).orElseThrow();
        repository.delete(acDelete);
    }
    
    public List<Account> findBySituacao(EAccountStatus sit) {
        return repository.findByStatus(sit);
    }
}
