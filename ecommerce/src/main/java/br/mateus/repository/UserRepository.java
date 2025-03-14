package br.mateus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.mateus.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByUsername(String username);
    User findByEmail(String email);
}
