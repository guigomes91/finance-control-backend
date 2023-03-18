package fctrl.com.br.fincontrol.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fctrl.com.br.fincontrol.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    
}
