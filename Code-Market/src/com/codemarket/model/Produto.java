package com.codemarket.model;

import java.util.Objects;

public class Produto {
    private final String nome;
    private final double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (!(objeto instanceof Produto)) return false;
        Produto produto = (Produto) objeto;
        return nome.equalsIgnoreCase(produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome.toLowerCase());
    }

    @Override
    public String toString() {
        return String.format("%s | R$ %.2f | estoque: %d", nome, preco, quantidade);
    }
}