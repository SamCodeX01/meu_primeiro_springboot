package com.example.meu_primeiro_springboot.repository;

import com.example.meu_primeiro_springboot.model.Produto;
import com.example.meu_primeiro_springboot.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Usuario>findByUserName(String username);
}
