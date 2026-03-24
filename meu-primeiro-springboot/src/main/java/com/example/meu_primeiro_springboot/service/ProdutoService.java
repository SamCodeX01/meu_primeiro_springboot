package com.example.meu_primeiro_springboot.service;

import com.example.meu_primeiro_springboot.model.Produto;
import com.example.meu_primeiro_springboot.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){

        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarprodutos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id){

        return produtoRepository.findById(id);
    }

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id){

        produtoRepository.deleteById(id);
    }

}
