package com.codemarket.ui;

import com.codemarket.objetos.Produto;
import com.codemarket.service.EstoqueService;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final EstoqueService estoque = new EstoqueService();

    public void executar() {
        int opcao;
        do {
            exibirOpcoes();
            opcao = lerInteiro("Escolha uma opcao: ");
            processarOpcao(opcao);
        } while (opcao != 0);
        scanner.close();
    }

    private void exibirOpcoes() {
        System.out.println("\n=== CodeMarket ===");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Listar produtos");
        System.out.println("3 - Buscar produto");
        System.out.println("4 - Ver estoque baixo");
        System.out.println("0 - Sair");
    }

    private void processarOpcao(int opcao) {
        try {
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    buscarProduto();
                    break;
                case 4:
                    listarEstoqueBaixo();
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } catch (IllegalArgumentException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    private void cadastrarProduto() {
        String nome = lerTexto("Nome: ");
        double preco = lerDouble("Preco: ");
        int quantidade = lerInteiro("Quantidade: ");
        estoque.cadastrarProduto(nome, preco, quantidade);
        System.out.println("Produto cadastrado com sucesso.");
    }

    private void listarProdutos() {
        if (estoque.listarProdutos().isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        estoque.listarProdutos().forEach(System.out::println);
    }

    private void buscarProduto() {
        Produto produto = estoque.buscarProduto(lerTexto("Nome para busca: ")).orElse(null);
        System.out.println(produto == null ? "Produto nao encontrado." : produto);
    }

    private void listarEstoqueBaixo() {
        if (estoque.listarEstoqueBaixo().isEmpty()) {
            System.out.println("Nenhum produto com estoque baixo.");
            return;
        }
        estoque.listarEstoqueBaixo().forEach(produto ->
                System.out.println("Alerta: " + produto));
    }

    private String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private int lerInteiro(String mensagem) {
        while (true) {
            try {
                return Integer.parseInt(lerTexto(mensagem));
            } catch (NumberFormatException erro) {
                System.out.println("Digite um numero inteiro valido.");
            }
        }
    }

    private double lerDouble(String mensagem) {
        while (true) {
            try {
                return Double.parseDouble(lerTexto(mensagem).replace(',', '.'));
            } catch (NumberFormatException erro) {
                System.out.println("Digite um numero valido.");
            }
        }
    }
}