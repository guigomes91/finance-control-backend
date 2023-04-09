package fctrl.com.br.fincontrol.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import fctrl.com.br.fincontrol.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    
}
