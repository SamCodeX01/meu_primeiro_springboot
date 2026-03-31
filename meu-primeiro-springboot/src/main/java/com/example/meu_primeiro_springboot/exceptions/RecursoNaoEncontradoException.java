package com.example.meu_primeiro_springboot.exceptions;

//A classe abaixo define uma exceção personalizada em Java. Ela serve para indicar que algo esperado
// (como um usuário ou produto no banco de dados) não foi encontrado.

public class RecursoNaoEncontradoException extends RuntimeException {

    //Construtor
    public RecursoNaoEncontradoException(String mensagem){//É o construtor. Ele permite que você passe uma frase personalizada explicando o que sumiu (ex: "Usuário com ID 5 não encontrado").
        super(mensagem); //Repassa essa frase para a classe pai (RuntimeException), que vai cuidar de armazenar e exibir a mensagem no log de erro.
    /*super() é usado para referenciar a classe pai (superclasse) imediata de um objeto.
    Ela serve principalmente para chamar construtores da classe pai (usando super()),
    acessar métodos sobrepostos ou acessar atributos da classe pai que foram ocultados por
    atributos de mesmo nome na classe filha. */

    }
}


/*extends RuntimeException: Isso é o mais importante. Ao herdar de RuntimeException,
você diz que essa é uma exceção do tipo "não checada".
Ou seja, o compilador não te obriga a usar try-catch toda vez que usar essa classe,
deixando o código mais limpo.*/