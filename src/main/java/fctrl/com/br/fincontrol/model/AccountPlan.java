package fctrl.com.br.fincontrol.model;

import java.util.UUID;

import fctrl.com.br.fincontrol.model.enumerations.ETypeAccountPlan;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "account_plan")
public class AccountPlan {

    @Id
    private UUID id;
    private String name;
    private ETypeAccountPlan type;
}