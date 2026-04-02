package com.example.meu_primeiro_springboot.repository;

import com.example.meu_primeiro_springboot.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUserName(String username);
}
