package br.com.fiap.livraria.spring.model.dto;

//Essa classe tem como objetivo ser usada pelo controller APENAS para atualizar o preço do livro. Ou seja, essa classe
//espera receber apenas o preco. Isso é uma boa pratica pois ajuda a separa seus métodos e deixa meio que "documentado" esse método especifico da aplicação
public class UpdatePrecoLivroDTO {
    private double preco;

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
