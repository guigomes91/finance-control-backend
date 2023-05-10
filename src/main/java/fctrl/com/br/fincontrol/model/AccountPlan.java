package fctrl.com.br.fincontrol.model;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import fctrl.com.br.fincontrol.model.enumerations.ETypeAccountPlan;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "account_plan")
public class AccountPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 100, message = "Tamanho do plano de conta deve ser entre {min} e {max}")
    private String name;

    @NotNull
    @Length(min = 3, max = 20)
    @Enumerated(EnumType.STRING)
    private ETypeAccountPlan type;
}