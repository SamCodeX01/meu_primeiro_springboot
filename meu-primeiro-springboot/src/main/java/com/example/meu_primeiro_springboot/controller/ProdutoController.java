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

    @GetMapping("{/id}")//O GetMapping irá capturar o valor do id na URL
    public ResponseEntity<Produto> buscarProduto(@PathVariable Long id){// @PathVariable Long id - Extrai o valor da variável id da URL e converte para o tipo Long
        return produtoService.buscarPorId(id) //metodo que busca pelo produto
                .map(ResponseEntity::ok) // para cada produto, chame o metodo ok da classe ResponseEntity passando o produto como argumento, Se encontrou, retorna status 200 OK com o produto
                     //.map(produto -> ResponseEntity.ok(produto))
                     //ResponseEntity::ok é equivalente a (parametro) -> ResponseEntity.ok(parametro)
                .orElse(ResponseEntity.notFound() // Se não encontrou, retorna status 404 Not Found
                .build()); //O build() é o metodo que constrói/finaliza o objeto ResponseEntity, cria o objeto completo
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
/*ResponseEntity é uma classe do Spring Boot (org.springframework.http) que representa a resposta HTTP completa de um endpoint REST: corpo,
status code e cabeçalhos. Ele permite alto nível de customização no controlador,
sendo ideal para definir status específicos (ex: 201 Created, 404 Not Found)
e cabeçalhos personalizados em vez de retornar apenas o objeto de dados.

Principais Características e Usos:
Controle Total: Permite personalizar o código de status HTTP, cabeçalhos (Headers) e o corpo da resposta (Body).
Flexibilidade: Comum em APIs REST para retornar respostas variadas dependendo da lógica de negócios,
como retornar um erro personalizado ou o objeto criado.
Métodos Auxiliares: Facilita o uso com métodos como ResponseEntity.ok(), ResponseEntity.created(), ResponseEntity.notFound(), ResponseEntity.badRequest(), etc..
Genérico: Pode ser tipado (ResponseEntity<T>) para definir o tipo de objeto no corpo da resposta.

 +2*/