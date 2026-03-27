package com.example.meu_primeiro_springboot.service;

import com.example.meu_primeiro_springboot.exceptions.RecursoNaoEncontradoException;
import com.example.meu_primeiro_springboot.model.Produto;
import com.example.meu_primeiro_springboot.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){

        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarprodutos(){
        return produtoRepository.findAll();
    }

    //public Optional<Produto> buscarPorId(Long id){
    public Produto buscarPorId(Long id){

        return produtoRepository.findById(id).orElseThrow(()-> new RuntimeException("Produto com ID " + id + " não encontrado! "));
    }

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id){

        if(!produtoRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Produto com ID " + id + "não encontrado!");
        }
        produtoRepository.deleteById(id);
    }

}
