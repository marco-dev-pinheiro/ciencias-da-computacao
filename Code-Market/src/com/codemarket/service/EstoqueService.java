package com.codemarket.service;

import com.codemarket.model.Produto;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class EstoqueService {
    private static final int LIMITE_ESTOQUE_BAIXO = 3;
    private final Set<Produto> produtos = new HashSet<>();

    public void cadastrarProduto(String nome, double preco, int quantidade) {
        validarNome(nome);
        if (preco <= 0) {
            throw new IllegalArgumentException("O preco deve ser maior que zero.");
        }
        validarQuantidade(quantidade);

        Produto produtoExistente = buscarProduto(nome).orElse(null);
        if (produtoExistente != null) {
            produtoExistente.adicionarQuantidade(quantidade);
            return;
        }
        produtos.add(new Produto(nome.trim(), preco, quantidade));
    }

    public Optional<Produto> buscarProduto(String nome) {
        if (nome == null) {
            return Optional.empty();
        }
        return produtos.stream()
                .filter(produto -> produto.getNome().equalsIgnoreCase(nome.trim()))
                .findFirst();
    }

    public Set<Produto> listarProdutos() {
        return Set.copyOf(produtos);
    }

    public Set<Produto> listarEstoqueBaixo() {
        Set<Produto> estoqueBaixo = new HashSet<>();
        for (Produto produto : produtos) {
            if (produto.getQuantidade() <= LIMITE_ESTOQUE_BAIXO) {
                estoqueBaixo.add(produto);
            }
        }
        return estoqueBaixo;
    }

    private void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto e obrigatorio.");
        }
    }

    private void validarQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
    }
}