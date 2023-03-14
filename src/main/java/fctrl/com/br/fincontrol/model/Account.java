package fctrl.com.br.fincontrol.model;

import java.sql.Date;
import java.util.UUID;

import fctrl.com.br.fincontrol.model.enumerations.EAccountStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Account {

  @Id
  private UUID id;
  private Date due;
  private Date payment;
  private int portion;
  private double amount;
  private AccountPlan type;
  private String description;
  private EAccountStatus status;
}