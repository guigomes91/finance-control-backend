package fctrl.com.br.fincontrol.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fctrl.com.br.fincontrol.model.AccountPlan;

@RepositoryRestResource(collectionResourceRel="account_plan", path="account_plan")
public interface AccountPlanRepository extends JpaRepository<AccountPlan, UUID> {
    
}
