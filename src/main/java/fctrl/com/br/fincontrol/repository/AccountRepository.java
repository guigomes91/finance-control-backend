package fctrl.com.br.fincontrol.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fctrl.com.br.fincontrol.model.Account;
import fctrl.com.br.fincontrol.model.enumerations.EAccountStatus;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    @Query("select a from Account a where status = :filtro")
    List<Account> findByStatus(EAccountStatus filtro);
}
