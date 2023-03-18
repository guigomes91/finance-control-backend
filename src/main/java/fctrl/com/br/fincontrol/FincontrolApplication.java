package fctrl.com.br.fincontrol;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fctrl.com.br.fincontrol.model.Account;
import fctrl.com.br.fincontrol.model.AccountPlan;
import fctrl.com.br.fincontrol.model.enumerations.EAccountStatus;
import fctrl.com.br.fincontrol.model.enumerations.ETypeAccountPlan;
import fctrl.com.br.fincontrol.repository.AccountRepository;

@SpringBootApplication
public class FincontrolApplication {

	public static void main(String[] args) {
		SpringApplication.run(FincontrolApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(AccountRepository repository) {
		return args -> {
			repository.deleteAll();
			Account ac = new Account();
			ac.setAmount(200.00);
			ac.setDescription("Internet");
			ac.setDue(new Date());
			ac.setPortion(1);
			ac.setStatus(EAccountStatus.PAID);

			AccountPlan type = new AccountPlan();
			type.setName("COMUNICACAO");
			type.setType(ETypeAccountPlan.PAY);
			ac.setType(type);
			repository.save(ac);

			ac = new Account();
			ac.setAmount(100.00);
			ac.setDescription("Energia");
			ac.setDue(new Date());
			ac.setPortion(1);
			ac.setStatus(EAccountStatus.PAID);

			type = new AccountPlan();
			type.setName("CASA");
			type.setType(ETypeAccountPlan.PAY);
			ac.setType(type);
			repository.save(ac);
		};
	}
}
