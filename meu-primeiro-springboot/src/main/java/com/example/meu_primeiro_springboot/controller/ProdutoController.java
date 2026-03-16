package com.example.meu_primeiro_springboot.controller;

import com.example.meu_primeiro_springboot.model.Produto;
import com.example.meu_primeiro_springboot.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listarProdutos(){
        return produtoService.listarprodutos();
    }

    @GetMapping("{/id}")//O GetMapping irá capturar o valor da id na URL
    public ResponseEntity<Produto> buscarProduto(@PathVariable Long id){// Caminho por variavel que é um o ID recebido pelo GetMapping
        return produtoService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto){
        return produtoService.salvarProduto(produto);//o método salvarProduto de produtoService esta salvando o objeto produto inteiro vindo pelo parametro acima
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
        //ResponseEntity retorna o status http
    }



}
