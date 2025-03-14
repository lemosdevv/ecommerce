package br.mateus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import br.mateus.dto.AuthenticationDTO;
import br.mateus.dto.LoginResponseDTO;
import br.mateus.dto.RegisterDTO;
import br.mateus.entity.User;
import br.mateus.infra.security.TokenService;
import br.mateus.repository.UserRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data) {
        try {
            if(data.username() == null || data.password() == null) {
                return ResponseEntity.badRequest().body("Username and password are required");
            }

            if(this.repository.findByUsername(data.username()) != null) {
                return ResponseEntity.badRequest().body("Username already exists");
            }
            
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
            User newUser = new User();
            newUser.setUsername(data.username());
            newUser.setPassword(encryptedPassword);
            newUser.setRole(data.role());

            this.repository.save(newUser);

            return ResponseEntity.ok().body("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateToken((User) auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(token));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }
}