package fctrl.com.br.fincontrol.model;

import java.util.Date;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import fctrl.com.br.fincontrol.model.enumerations.EAccountStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Account {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private UUID id;

  @NotNull
  @Column(nullable=false)
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date due;

  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date payment;

  @NotNull
  @Column(nullable=false)
  private int portion;

  @NotNull
  @Column(nullable=false)
  private double amount;

  @ManyToOne(fetch=FetchType.EAGER)
  private AccountPlan type;

  @NotNull
  @Column(length=200, nullable=false)
  @Length(min=5, max=100, message="Valor da descrição deve estar entre minimo {min} e máximo {max}")
  private String description;

  @NotNull
  @Column(nullable=false)
  private EAccountStatus status;

  /**
   * Data e hora de criação do objeto
   */
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date dateTimeCreated;

  /*
    * Data e hora de alteração
    */
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private Date dateTimeChanged;

  /*
    * Usuário que criou o objeto
    */
  @OneToOne
  private User userCreated;

  /*
    * Usuário que alterou o objeto
    */
  @OneToOne
  private User userChanged;
}