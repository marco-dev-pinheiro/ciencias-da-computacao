# Desenvolvimento de Software Reutilizável e Robusto em Java

[Clique aqui para abrir o mapa mental](https://notebook.google.com/notebook/bf68a4dd-23aa-49fd-8836-72b0452480f9/artifact/65922ddc-5d28-4838-97f4-cb9743419746?utm_source=nlm_web_share&utm_medium=google_oo&utm_campaign=art_share_1&utm_content=&utm_smc=nlm_web_share_google_oo_art_share_1_ )

## Introdução

O desenvolvimento de software reutilizável e robusto consiste em construir sistemas que possam ser aproveitados em diferentes situações, receber novas funcionalidades e lidar com falhas sem comprometer seu funcionamento.

Em Java, os princípios da Programação Orientada a Objetos (POO), a organização em módulos e as boas práticas de programação ajudam a alcançar esses objetivos.

O tema será dividido em três sub-ideias:

1. **Flexibilidade orientada a objetos:** preparar o software para mudanças e novas funcionalidades.
2. **Organização e reutilização:** dividir o sistema em componentes com responsabilidades bem definidas.
3. **Robustez e evolução:** prevenir erros, controlar falhas e facilitar a manutenção do código.

---

# 1. Flexibilidade orientada a objetos

## Definição

A flexibilidade é a capacidade de um sistema adaptar-se a novas funcionalidades e mudanças de requisitos com o mínimo de impacto no código existente.

Em Java, conceitos como abstração, encapsulamento, herança, interfaces, polimorfismo, sobrescrita e sobrecarga ajudam a desenvolver aplicações flexíveis.

## Pilares e recursos da POO

### 1.1. Abstração — a concepção

**Teoria**

A abstração consiste em representar as características essenciais de um objeto ou problema, ocultando detalhes de implementação que não precisam ser conhecidos por quem utiliza o componente.

Ela permite criar modelos que simplificam a interação com sistemas complexos.

**Analogia do cotidiano**

Ao dirigir um carro, utilizamos o volante e os pedais sem precisar conhecer todos os detalhes do funcionamento do motor e da injeção eletrônica.

Os comandos representam uma forma simplificada de interagir com um mecanismo complexo.

**Exemplo prático em Java**

```java
import java.time.LocalDate;
import java.time.Period;

public class ConversorDeData {

    public int calcularIdade(
            LocalDate dataNascimento,
            LocalDate dataAtual) {

        if (dataNascimento == null || dataAtual == null) {
            throw new IllegalArgumentException(
                "As datas são obrigatórias."
            );
        }

        if (dataNascimento.isAfter(dataAtual)) {
            throw new IllegalArgumentException(
                "A data de nascimento não pode estar no futuro."
            );
        }

        return Period.between(
            dataNascimento,
            dataAtual
        ).getYears();
    }
}
```

**Utilização**

```java
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        ConversorDeData conversor = new ConversorDeData();

        int idade = conversor.calcularIdade(
            LocalDate.of(1995, 5, 12),
            LocalDate.now()
        );

        System.out.println("Idade: " + idade + " anos.");
    }
}
```

O programa principal utiliza o método `calcularIdade()` sem precisar implementar o cálculo de anos, meses e dias.

**Quando utilizar?**

* Quando uma operação possui detalhes internos que não precisam ser expostos.
* Quando diferentes partes do sistema devem utilizar um serviço de maneira simples.
* Quando se deseja separar o que um componente faz de como ele realiza a tarefa.

### 1.2. Encapsulamento — a proteção

**Teoria**

O encapsulamento consiste em proteger o estado interno de um objeto e controlar como seus dados podem ser consultados ou modificados.

Em Java, o modificador `private` restringe o acesso direto aos atributos. Métodos públicos permitem disponibilizar operações controladas.

**Analogia do cotidiano**

Uma conta bancária permite realizar depósitos e saques por operações autorizadas. O cliente não pode simplesmente abrir o sistema interno do banco e substituir o saldo por qualquer valor.

**Exemplo prático em Java**

```java
public class ContaBancaria {

    private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldoInicial) {
        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException(
                "O titular é obrigatório."
            );
        }

        if (!Double.isFinite(saldoInicial) || saldoInicial < 0) {
            throw new IllegalArgumentException(
                "O saldo inicial deve ser válido e não negativo."
            );
        }

        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (!Double.isFinite(valor) || valor <= 0) {
            throw new IllegalArgumentException(
                "O depósito deve ser um valor positivo e válido."
            );
        }

        saldo += valor;
    }
}
```

**Utilização**

```java
public class Main {

    public static void main(String[] args) {

        ContaBancaria conta = new ContaBancaria(
            "Ana",
            500.00
        );

        conta.depositar(150.00);

        System.out.println("Titular: " + conta.getTitular());
        System.out.println("Saldo: R$ " + conta.getSaldo());
    }
}
```

O saldo não pode ser alterado diretamente de fora da classe. A modificação ocorre por meio do método `depositar()`, que valida a operação.

**Quando utilizar?**

* Quando os dados precisam respeitar regras de negócio.
* Quando uma alteração direta poderia deixar o objeto em um estado inválido.
* Quando se deseja modificar a implementação interna sem afetar quem utiliza a classe.

**Aplicação profissional:** em sistemas financeiros, comerciais e administrativos, o encapsulamento ajuda a preservar a consistência dos dados.

### 1.3. Herança — o relacionamento

**Teoria**

A herança permite que uma classe, chamada subclasse, herde características e comportamentos de outra classe, chamada superclasse.

Em Java, a palavra-chave `extends` estabelece esse relacionamento.

**Analogia do cotidiano**

Um aluno é uma pessoa. Ele possui características comuns às pessoas, como nome, mas também possui características específicas, como matrícula e curso.

**Exemplo prático em Java**

```java
public class Pessoa {

    protected String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public void apresentar() {
        System.out.println("Meu nome é " + nome);
    }
}
```

```java
public class Aluno extends Pessoa {

    private String matricula;
    private String curso;

    public Aluno(String nome, String matricula, String curso) {
        super(nome);
        this.matricula = matricula;
        this.curso = curso;
    }

    public void exibirMatricula() {
        System.out.println("Matrícula: " + matricula);
        System.out.println("Curso: " + curso);
    }
}
```

**Utilização**

```java
public class Main {

    public static void main(String[] args) {

        Aluno aluno = new Aluno(
            "Carlos",
            "2026001",
            "Ciência da Computação"
        );

        aluno.apresentar();
        aluno.exibirMatricula();
    }
}
```

O aluno herda o comportamento `apresentar()` da classe `Pessoa` e acrescenta funcionalidades específicas.

**Quando utilizar?**

* Quando existe uma relação real de especialização entre classes.
* Quando diferentes tipos compartilham comportamentos que fazem sentido em uma classe-base.
* Quando a hierarquia representa adequadamente o domínio do problema.

**Atenção:** a herança não deve ser usada apenas para evitar repetição de código. Em algumas situações, composição ou interfaces são alternativas melhores.

### 1.4. Interface — o contrato

**Teoria**

Uma interface define um contrato que determina quais operações uma classe deve disponibilizar. Ela permite que componentes diferentes sejam utilizados por meio de uma mesma abstração.

Em Java, uma classe utiliza `implements` para implementar uma interface.

**Analogia do cotidiano**

Diferentes carregadores podem seguir o mesmo padrão de conexão. Os dispositivos não precisam conhecer todos os detalhes internos de cada carregador para interagir com um conector compatível.

**Exemplo prático em Java**

```java
public interface Pagamento {

    void autorizar(double valor);
}
```

Qualquer classe que implemente esse contrato deve fornecer uma implementação de `autorizar()`.

**Quando utilizar?**

* Quando diferentes classes precisam oferecer a mesma operação.
* Quando se deseja reduzir a dependência entre os componentes.
* Quando novas implementações poderão ser adicionadas no futuro.

### 1.5. Polimorfismo — o mesmo comando, diferentes comportamentos

**Teoria**

O polimorfismo permite que objetos de diferentes classes sejam utilizados por meio de um mesmo tipo, executando comportamentos específicos de cada implementação.

**Analogia do cotidiano**

Uma maquininha de pagamento recebe diferentes formas de pagamento. O processo de solicitar uma autorização pode ser semelhante, mas as regras para cartão de crédito e Pix são diferentes.

**Exemplo prático em Java**

```java
public class PagamentoCartao implements Pagamento {

    @Override
    public void autorizar(double valor) {
        System.out.println(
            "Autorizando pagamento com cartão: R$ " + valor
        );
    }
}
```

```java
public class PagamentoPix implements Pagamento {

    @Override
    public void autorizar(double valor) {
        System.out.println(
            "Processando pagamento via Pix: R$ " + valor
        );
    }
}
```

**Utilização**

```java
public class Main {

    public static void main(String[] args) {

        Pagamento pagamento = new PagamentoCartao();
        pagamento.autorizar(150.00);

        pagamento = new PagamentoPix();
        pagamento.autorizar(150.00);
    }
}
```

A variável `pagamento` utiliza o tipo da interface, mas o comportamento executado depende do objeto concreto atribuído a ela.

**Quando utilizar?**

* Quando diferentes implementações devem responder à mesma operação.
* Quando se deseja adicionar novos comportamentos sem reescrever o código cliente.
* Quando se pretende evitar estruturas extensas de `if` e `switch` que verificam o tipo de cada objeto.

**Aplicação profissional:** um sistema de comércio eletrônico pode adicionar novos meios de pagamento sem exigir que toda a lógica de finalização da compra seja reescrita.

### 1.6. Sobrescrita e sobrecarga — especialização e flexibilidade de chamadas

**Sobrescrita (`@Override`)**

A sobrescrita acontece quando uma subclasse ou implementação fornece uma nova versão de um método herdado ou declarado por uma interface.

No exemplo anterior, `PagamentoCartao` e `PagamentoPix` sobrescrevem o método `autorizar()` para executar comportamentos específicos.

**Sobrecarga**

A sobrecarga permite definir métodos com o mesmo nome, mas com listas de parâmetros diferentes.

Exemplo:

```java
public class Calculadora {

    public double somar(double a, double b) {
        return a + b;
    }

    public double somar(double a, double b, double c) {
        return a + b + c;
    }
}
```

Os dois métodos têm o nome `somar`, mas recebem quantidades diferentes de argumentos.

**Quando utilizar?**

* **Sobrescrita:** quando uma implementação precisa adaptar um comportamento a uma situação específica.
* **Sobrecarga:** quando operações relacionadas podem aceitar diferentes conjuntos de parâmetros, mantendo uma nomenclatura consistente.

A sobrecarga não é determinada apenas pelo tipo de retorno: os parâmetros precisam diferenciar as assinaturas dos métodos.

## Síntese da sub-ideia 1

A flexibilidade orientada a objetos permite construir sistemas preparados para mudanças. Abstração e interfaces definem formas consistentes de utilização; encapsulamento protege os dados; herança reutiliza comportamentos em hierarquias apropriadas; e polimorfismo permite substituir implementações sem alterar necessariamente o código cliente.

---

# 2. Organização e reutilização

## Definição

A organização e a reutilização consistem em dividir uma aplicação em componentes bem definidos, responsáveis por tarefas específicas, que possam ser testados, mantidos e reaproveitados sem criar dependências desnecessárias.

## 2.1. Modularidade — dividir para organizar

**Teoria**

A modularidade consiste em dividir um sistema em módulos menores, cada um com uma responsabilidade definida.

Cada módulo pode representar uma parte do negócio, como pagamentos, clientes, relatórios ou autenticação.

**Analogia do cotidiano**

Uma oficina possui setores responsáveis por atividades diferentes. A equipe de diagnóstico identifica o problema, a equipe de manutenção executa o reparo e o setor administrativo cuida dos registros.

Essa divisão facilita a organização do trabalho.

**Quando utilizar?**

* Quando o programa começa a concentrar muitas responsabilidades em uma única classe.
* Quando partes diferentes da aplicação podem evoluir independentemente.
* Quando se deseja facilitar os testes e a manutenção.

## 2.2. Coesão — manter responsabilidades relacionadas juntas

**Teoria**

A coesão representa o grau de relação entre as responsabilidades de um módulo. Uma classe com alta coesão concentra operações relacionadas a um propósito claro.

**Exemplo**

Uma classe `CalculadoraDeFrete` deve calcular fretes, e não enviar e-mails, cadastrar clientes e gerar relatórios financeiros.

Quanto mais responsabilidades sem relação entre si forem colocadas na mesma classe, mais difícil será compreendê-la e modificá-la.

**Quando utilizar?**

Ao criar uma classe ou um módulo, pergunte: todas as operações deste componente contribuem para uma mesma responsabilidade?

## 2.3. Acoplamento — controlar as dependências

**Teoria**

O acoplamento representa o grau de dependência entre componentes. Um sistema com baixo acoplamento permite substituir ou modificar uma parte com menos impacto nas demais.

**Analogia do cotidiano**

Se uma empresa depende de um único fornecedor para todas as suas operações, trocar esse fornecedor pode ser complicado. Se existem contratos bem definidos e alternativas compatíveis, a substituição tende a ser mais simples.

**Exemplo em Java**

Em vez de uma classe depender diretamente de uma implementação específica:

```java
Pagamento pagamento = new PagamentoCartao();
```

Um serviço pode receber uma implementação por meio de uma interface:

```java
public class ProcessadorDePagamento {

    private final Pagamento pagamento;

    public ProcessadorDePagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void processar(double valor) {
        pagamento.autorizar(valor);
    }
}
```

O processador não precisa conhecer os detalhes de cada forma de pagamento. Ele depende do contrato `Pagamento`.

**Quando utilizar?**

* Quando um componente pode precisar de diferentes implementações.
* Quando se deseja facilitar testes com objetos substitutos.
* Quando mudanças em um módulo não devem exigir alterações em vários outros.

## 2.4. Composição — construir objetos a partir de outros objetos

**Teoria**

A composição consiste em construir uma classe utilizando outros objetos como partes de sua estrutura. Em vez de depender exclusivamente de hierarquias de herança, cada componente contribui com uma responsabilidade específica.

**Analogia do cotidiano**

Um computador é composto por processador, memória e armazenamento. Cada componente tem uma função própria e participa do funcionamento do conjunto.

**Exemplo em Java**

```java
public class Pedido {

    private final ProcessadorDePagamento processador;

    public Pedido(ProcessadorDePagamento processador) {
        this.processador = processador;
    }

    public void finalizar(double valor) {
        processador.processar(valor);
    }
}
```

O pedido utiliza um processador de pagamento em vez de implementar diretamente todas as regras de pagamento.

**Quando utilizar?**

* Quando uma classe precisa utilizar serviços de outros componentes.
* Quando se deseja separar regras de negócio em objetos especializados.
* Quando diferentes combinações de componentes podem ser necessárias.

A composição favorece a reutilização e a flexibilidade, mas é importante definir claramente quem cria, mantém e descarta cada objeto.

## 2.5. Separação de responsabilidades — cada componente com sua função

Considere um sistema de vendas que precisa validar um pagamento, processar a operação e apresentar o resultado ao usuário.

Uma organização inadequada colocaria todas essas tarefas em uma única classe.

Uma organização melhor separa as responsabilidades:

| Componente               | Responsabilidade                             |
| ------------------------ | -------------------------------------------- |
| `Pagamento`              | Definir o contrato de pagamento.             |
| `PagamentoCartao`        | Implementar as regras específicas do cartão. |
| `PagamentoPix`           | Implementar as regras específicas do Pix.    |
| `ProcessadorDePagamento` | Coordenar a execução do pagamento.           |
| `Pedido`                 | Representar o pedido e sua finalização.      |
| `Main`                   | Iniciar o programa e demonstrar seu uso.     |

Essa estrutura facilita a identificação de erros e reduz a necessidade de modificar classes que não estão relacionadas à mudança.

## 2.6. Pacotes e interfaces — organizando a aplicação

**Pacotes**

Pacotes agrupam classes e interfaces relacionadas, evitando que todo o sistema fique concentrado em um único espaço de nomes.

Uma organização inicial possível seria:

```text
src/
└── main/
    └── java/
        └── br/
            └── com/
                └── exemplo/
                    ├── app/
                    │   └── Main.java
                    ├── dominio/
                    │   └── Pedido.java
                    ├── pagamento/
                    │   ├── Pagamento.java
                    │   ├── PagamentoCartao.java
                    │   └── PagamentoPix.java
                    └── servico/
                        └── ProcessadorDePagamento.java
```

Essa estrutura separa o ponto de entrada, as entidades do negócio, as implementações de pagamento e os serviços que coordenam operações.

**Interfaces**

As interfaces estabelecem contratos entre componentes. Assim, o serviço pode depender de `Pagamento` em vez de conhecer diretamente `PagamentoCartao` ou `PagamentoPix`.

**Quando utilizar?**

* Pacotes: quando o número de classes aumenta e é necessário agrupar responsabilidades.
* Interfaces: quando diferentes implementações precisam obedecer ao mesmo contrato.
* Ambos: quando a aplicação exige uma arquitetura que possa crescer sem concentrar todas as dependências em uma única classe.

## Síntese da sub-ideia 2

A organização e a reutilização são favorecidas pela modularidade, pela alta coesão e pelo baixo acoplamento. A composição permite combinar objetos especializados, enquanto pacotes e interfaces ajudam a estabelecer limites claros entre os componentes.

---

# 3. Robustez e evolução

## Definição

A robustez é a capacidade de um sistema funcionar de maneira previsível, controlar situações inesperadas e preservar a consistência de seus dados. A evolução é a capacidade de modificar e ampliar o software sem comprometer desnecessariamente o que já funciona.

Em Java, validação, exceções, refatoração, legibilidade e eficiência contribuem para esses objetivos.

## 3.1. Validação — impedir dados inválidos

**Teoria**

A validação verifica se os dados recebidos atendem às regras esperadas antes de serem utilizados.

Um sistema robusto não deve presumir que todas as entradas são válidas.

**Analogia do cotidiano**

Um formulário bancário verifica se os campos obrigatórios foram preenchidos e se os valores obedecem às regras antes de aceitar uma operação.

**Exemplo em Java**

```java
public class ValidadorDeValor {

    public void validar(double valor) {
        if (!Double.isFinite(valor) || valor <= 0) {
            throw new IllegalArgumentException(
                "O valor deve ser positivo e finito."
            );
        }
    }
}
```

O método rejeita valores negativos, zero, infinito e `NaN`, que não são apropriados para uma operação monetária comum.

**Quando utilizar?**

* Ao receber informações digitadas pelo usuário.
* Ao processar dados importados de arquivos ou planilhas.
* Ao executar operações financeiras ou regras de negócio.
* Ao receber informações de APIs ou outros sistemas.

A validação deve ocorrer nos limites adequados do sistema, especialmente antes de operações que dependem da integridade dos dados.

## 3.2. Exceções — controlar falhas

**Teoria**

Exceções representam situações que impedem a execução normal de uma operação. Java permite lançar exceções com `throw` e tratá-las com estruturas como `try` e `catch`.

**Analogia do cotidiano**

Se um caixa eletrônico não consegue concluir um saque por falta de saldo, a operação deve ser interrompida e uma mensagem apropriada deve informar o problema.

**Exemplo de falha que deve ser controlada**

```java
public class Main {

    public static void main(String[] args) {

        try {
            ContaBancaria conta = new ContaBancaria(
                "Ana",
                500.00
            );

            conta.depositar(-100.00);

        } catch (IllegalArgumentException erro) {
            System.out.println(
                "Não foi possível realizar a operação: "
                + erro.getMessage()
            );
        }
    }
}
```

O exemplo utiliza a classe `ContaBancaria` apresentada na primeira sub-ideia.

Como o valor do depósito é inválido, o método lança uma exceção. O bloco `catch` captura essa situação e apresenta uma mensagem em vez de deixar a exceção não tratada encerrar o fluxo normal do programa.

**Quando utilizar?**

* Quando uma operação não pode continuar devido a uma condição inválida.
* Quando uma falha externa, como um arquivo inexistente, precisa ser tratada.
* Quando é necessário informar o problema de forma clara a quem utiliza o sistema.

**Boa prática:** capture exceções específicas que possam ser tratadas de maneira útil. Evite capturar qualquer exceção indiscriminadamente ou ignorar erros sem registrar ou comunicar o ocorrido.

## 3.3. Refatoração — melhorar sem alterar o comportamento esperado

**Teoria**

A refatoração consiste em modificar a estrutura interna do código sem alterar seu comportamento observável esperado.

Seu objetivo é tornar o programa mais simples de compreender, testar e manter.

**Exemplo**

Imagine um método que calcula o valor final de uma compra e, dentro dele, também valida o cliente, aplica descontos, registra o pagamento e imprime um relatório.

A refatoração pode separar essas operações em métodos ou classes específicos, mantendo as mesmas regras de negócio.

```java
public class CalculadoraDeDesconto {

    public double aplicarDesconto(double valor, double percentual) {
        if (!Double.isFinite(valor)
                || !Double.isFinite(percentual)
                || valor < 0
                || percentual < 0
                || percentual > 100) {

            throw new IllegalArgumentException(
                "Valor ou percentual inválido."
            );
        }

        return valor * (1 - percentual / 100);
    }
}
```

O cálculo foi isolado em uma classe com uma responsabilidade definida. Isso facilita sua reutilização e seus testes.

**Quando utilizar?**

* Quando métodos ficam extensos e difíceis de compreender.
* Quando uma mesma regra aparece repetidamente.
* Quando uma classe concentra responsabilidades diferentes.
* Quando uma nova funcionalidade exige reorganizar o código existente.

Refatorações devem ser acompanhadas por testes para verificar se o comportamento esperado foi preservado.

## 3.4. Legibilidade — escrever código que possa ser compreendido

**Teoria**

A legibilidade é a facilidade com que uma pessoa consegue compreender a intenção e o funcionamento do código.

Código legível reduz o tempo necessário para encontrar erros, revisar alterações e desenvolver novas funcionalidades.

**Exemplo inadequado**

```java
double x = v * p / 100;
```

**Exemplo mais legível**

```java
double valorDesconto = valorCompra * percentualDesconto / 100;
```

O segundo exemplo utiliza nomes que expressam a finalidade das variáveis.

**Boas práticas**

* Utilizar nomes claros para classes, métodos e variáveis.
* Manter métodos com responsabilidades bem definidas.
* Evitar duplicação de código.
* Seguir as convenções de nomenclatura do Java.
* Comentar principalmente decisões que não sejam evidentes pelo código.

**Quando utilizar?**

Durante todo o desenvolvimento, especialmente quando o sistema será mantido por outras pessoas ou quando as regras de negócio são complexas.

## 3.5. Eficiência — utilizar recursos adequadamente

**Teoria**

A eficiência está relacionada ao uso de tempo de processamento, memória e outros recursos necessários para executar uma operação.

Um código eficiente resolve o problema corretamente sem desperdiçar recursos de forma desnecessária.

**Analogia do cotidiano**

Se uma empresa precisa localizar um registro entre milhares de documentos, um índice organizado pode ser muito mais eficiente do que examinar cada documento individualmente.

**Exemplo em Java**

```java
import java.util.HashMap;
import java.util.Map;

public class ConsultaDePrecos {

    public static void main(String[] args) {

        Map<String, Double> precos = new HashMap<>();

        precos.put("Teclado", 120.00);
        precos.put("Mouse", 65.00);
        precos.put("Monitor", 900.00);

        double preco = precos.getOrDefault("Mouse", 0.0);

        System.out.println("Preço: R$ " + preco);
    }
}
```

O `HashMap` permite consultar valores por chave com custo médio constante, \(O(1)\), sob condições usuais de distribuição dos hashes.

Em comparação, procurar um elemento em uma lista sem índice pode exigir uma busca linear, \(O(n)\).

**Quando utilizar?**

* Quando o volume de dados começa a crescer.
* Quando uma operação é executada muitas vezes.
* Quando existem gargalos identificados por medições.
* Quando a escolha da estrutura de dados influencia o desempenho.

**Boa prática:** primeiro garanta a correção e a clareza. Otimize com base em medições e nas necessidades reais da aplicação, evitando complexidade desnecessária.

## 3.6. Preparando o software para futuras alterações

Considere que um sistema de pagamentos aceita inicialmente cartão e Pix, mas a empresa deseja adicionar boleto bancário no futuro.

Uma solução rígida pode exigir alterações em várias partes do sistema sempre que um novo método for criado.

Uma solução mais preparada para mudanças utiliza a interface `Pagamento`, implementações específicas e um serviço que depende do contrato.

Para adicionar um novo método, basta criar outra implementação:

```java
public class PagamentoBoleto implements Pagamento {

    @Override
    public void autorizar(double valor) {
        System.out.println(
            "Gerando cobrança por boleto: R$ " + valor
        );
    }
}
```

O serviço `ProcessadorDePagamento` continua utilizando o método `autorizar()` da interface, sem precisar conhecer os detalhes da nova classe.

Esse exemplo demonstra como abstração, baixo acoplamento e polimorfismo podem reduzir o impacto de futuras mudanças.

Em uma aplicação real, o boleto exigiria regras próprias de emissão, vencimento, confirmação e tratamento de falhas. O exemplo demonstra a estrutura extensível, não uma integração bancária completa.

## Síntese da sub-ideia 3

A robustez depende da validação de dados, do tratamento adequado de exceções e da preservação de estados válidos. A evolução do software é favorecida por código legível, refatoração contínua, testes e decisões de arquitetura que permitam incorporar novas funcionalidades com menor impacto.

---

# Conclusão

O desenvolvimento de software reutilizável e robusto em Java depende da combinação de princípios de orientação a objetos, organização arquitetural e boas práticas de engenharia de software.

A flexibilidade orientada a objetos permite adaptar comportamentos e adicionar funcionalidades. A organização e a reutilização distribuem responsabilidades entre componentes com maior coesão e menor acoplamento. A robustez e a evolução ajudam a controlar falhas, manter a consistência e preparar a aplicação para mudanças futuras.

Esses princípios não devem ser aplicados isoladamente. Uma interface, por exemplo, pode contribuir para o polimorfismo e também reduzir o acoplamento. O encapsulamento pode proteger o estado de um objeto e, ao mesmo tempo, centralizar regras de validação. A refatoração pode melhorar a legibilidade e tornar os testes mais simples.

Portanto, desenvolver software de qualidade não significa apenas fazer o programa funcionar. Significa construir uma solução que possa ser compreendida, testada, mantida e ampliada de maneira segura e previsível.

## Referências para estudo

* Documentação oficial do Java: https://docs.oracle.com/en/java/
* Tutorial oficial de classes e objetos: https://docs.oracle.com/javase/tutorial/java/javaOO/
* Documentação da linguagem Java: https://docs.oracle.com/javase/specs/
* Princípios de design e boas práticas: https://refactoring.guru/design-patterns

