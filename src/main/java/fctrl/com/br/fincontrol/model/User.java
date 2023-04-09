package fctrl.com.br.fincontrol.model;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(length = 10, nullable = false)
    @Length(min=8, max=10, message="Senha deve ter o minimo {min} de caracteres e máximo {max}")
    private String password;

    @NotBlank
    @Length(min=4)
    private String login;

    @NotBlank
    private String name;
}