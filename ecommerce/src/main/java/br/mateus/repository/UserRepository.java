package br.mateus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mateus.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
