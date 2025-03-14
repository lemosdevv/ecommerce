package br.mateus.dto;

import br.mateus.entity.UserRole;

public record RegisterDTO(String username, String password, UserRole role) {
    

}
