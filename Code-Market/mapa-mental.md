# Desenvolvimento de uma solução Java confiável. 
{curso de ciencias da computação}
java -cp out com.codemarket.Main
## Implementação e organização

Sistema de cadastro de produtos e controle de estoque baixo. Menu numerico voce escolhe as opções 

 === CodeMarket ===  

[1] - Cadastrar produto 

[2] - Listar produtos 

[3] - Buscar produto 

[4] - Ver estoque baixo 

[0] - Sair 


### Boas práticas
  - Nomes de variaveis explicitamente declaradas com nomes claros e identificaveis de forma simples. 

  - Identação consistente facilitando a leitura do codigo 

### Exemplo :

 ´´´ 

    public Set<Produto> listarEstoqueBaixo() {
        Set<Produto> estoqueBaixo = new HashSet<>();
        for (Produto produto : produtos) {
            if (produto.getQuantidade() <= LIMITE_ESTOQUE_BAIXO) {
                estoqueBaixo.add(produto);
            }
        }
        return estoqueBaixo;
    }
    
## Integração e modularização

A integração de estruturas combina diferentes estruturas de controle e módulos para organizar o fluxo do sistema e dividir suas responsabilidades.

**Sequencial:** executa as instruções em uma ordem definida.

**Condicional:** escolhe caminhos diferentes de acordo com uma condição.

**Repetição:** executa uma tarefa várias vezes enquanto uma condição for atendida.

### Métodos

- `cadastrarProduto()` adiciona um produto ao estoque.
- `listarEstoqueBaixo()` identifica produtos com pouca quantidade.

### Exemplo

O método abaixo cadastra produtos na coleção do estoque. Ele integra sequência, condições e chamadas de métodos para validar os dados e evitar duplicidade:

```java
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
```


## Subideia 3 — Testes, depuração e validação

Testar é comparar o resultado esperado com o resultado obtido para verificar se o sistema funciona corretamente.

**Entrada válida:** `quantidade = 10`, pois é um número inteiro maior que zero.

**Entrada inválida:** `quantidade = -2`, pois a Code-Market não permite quantidades menores ou iguais a zero.

**Caso de exemplo no sistema:** ao cadastrar um produto na Code-Market, o método `cadastrarProduto()` recebe o nome, o preço e a quantidade do produto.

**Depuração:** acompanhar o valor de `quantidade` durante a execução de `cadastrarProduto()` e verificar se ele chega corretamente ao método `validarQuantidade()`.

**Tratamento:** utilizar `if` em `validarQuantidade()` para identificar valores inválidos e lançar 

`IllegalArgumentException`, impedindo o cadastro de quantidades negativas.






