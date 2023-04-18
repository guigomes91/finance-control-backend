package fctrl.com.br.fincontrol.model;

import java.util.Date;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length=10, nullable=false)
    @Length(min=8, max=10, message="Senha deve ter o minimo {min} de caracteres e máximo {max}")
    private String password;

    @NotBlank
    @Length(min=4, max=50)
    @Column(length=50, nullable=false)
    private String login;

    @NotBlank
    @Length(min=3, max=100, message="Nome deve ter o minimo {min} de caracteres e máximo {max}")
    @Column(length=100, nullable=false)
    private String name;

    /**
     * Data e hora de criação do objeto
     */
    private Date dateTimeCreated;

    /*
     * Data e hora de alteração
     */
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
