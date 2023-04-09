package fctrl.com.br.fincontrol.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fctrl.com.br.fincontrol.model.Account;

public interface AccountService {

    Account update(Account acc, UUID id);

    Page<Account> list(Pageable pageable);

    Account listById(UUID id);

    Account save(Account acc);

    void delete(UUID id);
}
