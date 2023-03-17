package fctrl.com.br.fincontrol.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fctrl.com.br.fincontrol.model.Account;
import fctrl.com.br.fincontrol.model.AccountPlan;
import fctrl.com.br.fincontrol.model.enumerations.EAccountStatus;
import fctrl.com.br.fincontrol.model.enumerations.ETypeAccountPlan;

@RestController
@RequestMapping("/account")
public class AccountController {
    
    @GetMapping
    public List<Account> getAccount() {
        Account ac = new Account();
        ac.setId(UUID.randomUUID());
        ac.setAmount(200.00);
        ac.setDescription("Internet");
        ac.setDue(new Date());
        ac.setPortion(1);
        ac.setStatus(EAccountStatus.PAID);

        AccountPlan type = new AccountPlan();
        type.setId(UUID.randomUUID());
        type.setName("CASA");
        type.setType(ETypeAccountPlan.PAY);
        ac.setType(type);

        return List.of(ac, ac, ac);
    }
}
