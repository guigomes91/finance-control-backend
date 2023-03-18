package fctrl.com.br.fincontrol.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import fctrl.com.br.fincontrol.model.AccountPlan;

public interface AccountPlanRepository extends JpaRepository<AccountPlan, UUID> {
    
}
