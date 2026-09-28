---
title: Aplicação Orientada a Objetos em Java
markmap:
  colorFreezeLevel: 2
  maxWidth: 380
  initialExpandLevel: 3
  color:
    - '#A855F7' # Roxo    -> Classes e Objetos
    - '#06B6D4' # Ciano   -> Encapsulamento
    - '#10B981' # Verde   -> Relacionamentos
    - '#F59E0B' # Âmbar   -> Organização
    - '#F43F5E' # Rosa    -> Boas práticas
  extraCss: |
    .markmap {
      background-color: #0F172A !important;
    }
    .markmap-node text,
    .markmap-node foreignObject {
      fill: #F8FAFC !important;
      color: #F8FAFC !important;
    }
    .markmap-node code {
      background: #1E293B !important;
      color: #38BDF8 !important;
      padding: 1px 5px;
      border-radius: 4px;
    }
    .markmap-node pre {
      background: #1E293B !important;
      border-left: 3px solid #A855F7;
      border-radius: 6px;
    }
---

# ☕ Aplicação Orientada a Objetos em Java

> Modelar o mundo real em **objetos** que guardam dados e executam ações

## 🧱 1. Classes, Objetos e Responsabilidades

### 📐 Classe
- **Molde** (planta) para criar objetos
- Define **o que o objeto tem** (atributos) e **o que ele faz** (métodos)
- 🏭 Analogia: a planta de um carro ≠ o carro em si

### 🏷️ Atributos
- Características que guardam o **estado** do objeto
- Exemplo:
  ```java
  public class Carro {
      String modelo = "Opala";
      int ano = 1985;
      String motor = "4.1";
  }
  ```

### ⚙️ Métodos
- **Comportamentos**: ações que o objeto executa
- 🟢 `acelerar()` → aumenta a velocidade
- 🛑 `frear()` → zera a velocidade
- ⛽ `abastecer()` → adiciona combustível
- 🔁 **Sobrecarga**: mesmo nome, parâmetros diferentes
  - `abastecer()` e `abastecer(double litros)`

### 🔨 Construtor
- Método especial que **inicializa** o objeto
- Tem o **mesmo nome da classe** e **não tem retorno**
- Chamado pela palavra-chave `new`
- 🏭 Analogia: a equipe da linha de montagem que define cor e modelo antes do carro sair da fábrica
- Exemplo:
  ```java
  public Carro(String modelo, int ano) {
      this.modelo = modelo;
      this.ano = ano;
  }

  Carro opala = new Carro("Opala", 1985);
  ```
- 🧭 `this` → referência ao **próprio objeto**
- Se nenhum construtor for escrito, o Java cria um **padrão (vazio)**

### 🧩 Objeto (instância)
- Elemento concreto criado a partir da classe
- Cada objeto tem **seu próprio estado**
- Uma classe → **vários objetos**
  - `opala`, `fusca`, `chevette`

### 🎯 Responsabilidade de uma classe
- 🧠 **O que a classe sabe** → guarda informações do seu contexto
  - `Cliente` conhece nome, e-mail e telefone
- 🛠️ **O que a classe faz** → executa ações e regras de negócio
  - `Cliente` atualiza dados ou efetua pagamento
- ☝️ Regra de ouro: **uma classe, uma responsabilidade**

## 🔒 2. Encapsulamento e Controle de Estado

### 🙈 Atributos privados
- Usam o modificador `private`
- Só são acessados **dentro da própria classe**
- Protegem o objeto de valores inválidos
- Exemplo:
  ```java
  public class Conta {
      private double saldo;   // protegido

      public double getSaldo() {
          return saldo;
      }
  }
  ```

### 🚦 Controle de acesso
- 🌍 `public`
  - Visível em **qualquer lugar** do projeto
- 🛡️ `protected`
  - Mesmo pacote **+ subclasses** (mesmo em outros pacotes)
- 📦 `default` (sem palavra-chave)
  - Apenas **dentro do mesmo pacote**
- 🔐 `private`
  - Exclusivo da **própria classe**
- 📊 Do mais aberto ao mais fechado:
  - `public` → `protected` → `default` → `private`

### 👀 Getters (métodos de consulta)
- **Função:** retornar o valor atual de um atributo encapsulado
- **Nome:** prefixo `get` + atributo com inicial maiúscula
  - `getNome()`, `getSaldo()`
- **Retorno:** mesmo tipo do atributo
- **Segurança:** acesso controlado, sem expor o atributo

### ✏️ Setters (métodos de alteração)
- **Função:** alterar o valor de um atributo **com validação**
- **Nome:** prefixo `set` + atributo
  - `setNome(String nome)`
- Exemplo:
  ```java
  public void depositar(double valor) {
      if (valor > 0) {
          saldo += valor;
      }
  }
  ```
- 💡 Prefira **métodos com regra de negócio** (`depositar`, `sacar`) a setters "cegos"

### ✅ Benefícios
- Protege a **integridade** dos dados
- Permite **mudar a implementação** sem quebrar quem usa a classe
- Centraliza **validações** em um só lugar

## 🔗 3. Relacionamentos entre Classes

### 🤝 Associação
- Um objeto **usa** outro, mas ambos **existem de forma independente**
- 🛒 `Pedido` → `Cliente` (quem fez a compra)
- Se o pedido sumir, o cliente continua existindo

### 🧬 Composição
- Relação **parte-todo**: a parte **depende do todo**
- 📦 `Pedido` é composto por `ItemPedido`
- Excluiu o pedido → **os itens deixam de existir**
- 🔑 Teste rápido: *"a parte faz sentido sozinha?"* Se não, é composição

### 🧺 Agregação
- Parte-todo **fraca**: a parte **sobrevive** sem o todo
- Exemplo: `Time` tem `Jogadores`, e o jogador continua existindo se o time acabar

### 🔄 Colaboração entre objetos
- Objetos **conversam e dividem tarefas** para cumprir regras complexas
- 🔗 `ItemPedido` → referencia um `Produto` do catálogo
- 🧮 **Distribuição de responsabilidades**
  - `Pedido` **não** gerencia produtos
  - `Pedido` administra sua **coleção de itens**
  - Percorre os itens para calcular o **valor total**

### 🗺️ Visão geral do domínio
- ```
  Cliente ──(associação)──► Pedido
  Pedido  ◆──(composição)── ItemPedido
  ItemPedido ──(referência)──► Produto
  ```

### 🔢 Cardinalidade
- `Cliente` **1 ── N** `Pedido`
- `Pedido` **1 ── N** `ItemPedido`
- `ItemPedido` **N ── 1** `Produto`

### 🧾 Exemplo em código
- ```java
  public class Pedido {
      private Cliente cliente;                // associação
      private List<ItemPedido> itens;         // composição

      public double calcularTotal() {
          double total = 0;
          for (ItemPedido item : itens) {
              total += item.getSubtotal();
          }
          return total;
      }
  }
  ```

## 🗂️ 4. Organização em Arquivos e Pacotes

### 📄 Um arquivo por classe
- `Cliente.java`
- `Pedido.java`
- `ItemPedido.java`
- ⚠️ O nome do arquivo deve ser **igual** ao da classe pública

### 📦 Pacotes
- Agrupam classes por **responsabilidade no domínio**
- `models` / `entities` → dados do negócio
- `services` → regras de negócio
- `repositories` → acesso a dados
- Exemplo de estrutura:
  ```
  src/
  ├── models/
  │   ├── Cliente.java
  │   ├── Pedido.java
  │   └── ItemPedido.java
  └── services/
      └── PedidoService.java
  ```

### 🧲 Coesão e acoplamento
- **Alta coesão** → a classe faz **uma coisa bem feita**
- **Baixo acoplamento** → classes **dependem pouco** umas das outras

## 🌟 5. Boas Práticas e Próximos Passos

### ✅ Boas práticas
- Atributos sempre `private`
- Nomes de classe em **PascalCase** (`ItemPedido`)
- Nomes de métodos e atributos em **camelCase** (`getSaldo`)
- Classes pequenas e focadas
- Validar dados **dentro** da classe

### ⚠️ Erros comuns
- Deixar atributos `public`
- Criar getters e setters para **tudo** sem pensar
- Classe "faz-tudo" com responsabilidades demais
- Confundir **classe** (molde) com **objeto** (instância)

### 🚀 Os 4 pilares da POO
- ✅ **Encapsulamento** → visto neste mapa
- ✅ **Abstração** → modelar só o que importa (as classes)
- ⏭️ **Herança** → reaproveitar código com `extends`
- ⏭️ **Polimorfismo** → mesma chamada, comportamentos diferentes
- 🔭 Depois: **interfaces**, **classes abstratas** e **SOLID**
