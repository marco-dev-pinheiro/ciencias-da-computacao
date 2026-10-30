# Notebook de Engenharia de Software
## O ciclo de construção de uma solução computacional

> **Objetivo deste notebook:** servir como guia de consulta rápida para transformar um problema real em uma solução computacional útil, compreensível, testável e sustentável.
>
> **Princípio central:** não comece pelo código. Comece entendendo o problema que o código deverá resolver.

---

## Como usar este notebook

Use as oito etapas como um ciclo de trabalho. Em projetos pequenos, algumas atividades podem ser feitas em conjunto; em projetos maiores, cada etapa pode exigir documentos, reuniões e validações próprias.

- **Antes de começar:** leia o objetivo e as perguntas da etapa.
- **Durante o trabalho:** responda às perguntas e marque o checklist.
- **Ao terminar:** confira o entregável e o critério de avanço.
- **Se descobrir algo novo:** volte à etapa anterior e atualize suas decisões. Isso faz parte do processo.

### Visão rápida do ciclo

1. [Compreender o contexto](#1-compreender-o-contexto)
2. [Identificar as partes interessadas](#2-identificar-as-partes-interessadas-stakeholders)
3. [Formular o problema](#3-formular-o-problema)
4. [Levantar requisitos](#4-levantar-requisitos)
5. [Modelar a solução](#5-modelar-a-solução)
6. [Implementar](#6-implementar)
7. [Avaliar](#7-avaliar)
8. [Melhorar continuamente](#8-melhorar-continuamente)

**Regra de bolso:** se você não consegue explicar qual problema está resolvendo, para quem e como saberá se resolveu, ainda não está pronto para começar a implementação.

---

# 1. Compreender o contexto

## Objetivo

Investigar a situação real antes de propor uma solução. O propósito é compreender como o trabalho acontece hoje, onde estão as dificuldades e quais condições limitam as alternativas.

**Analogia:** antes de consertar uma máquina, você observa como ela opera, identifica os sintomas e investiga suas causas. Trocar uma peça sem diagnóstico pode não resolver nada.

## Perguntas orientadoras

- [ ] Onde o problema acontece?
- [ ] Quem é afetado?
- [ ] Com que frequência ocorre?
- [ ] Como as pessoas lidam com ele atualmente?
- [ ] Quais ferramentas ou soluções já existem?
- [ ] Quais são as principais dificuldades e limitações?
- [ ] Há restrições de tempo, orçamento, infraestrutura, segurança ou legislação?
- [ ] O que já sabemos e o que ainda precisamos descobrir?

## O que fazer

1. Observe o processo atual.
2. Converse com pessoas envolvidas e consulte materiais existentes.
3. Registre exemplos concretos, exceções e dificuldades.
4. Separe **fatos observados**, **hipóteses** e **opiniões**.
5. Identifique informações que ainda precisam ser verificadas.

## Exemplo — Cidadão Conectado

Imagine uma plataforma que ajuda cidadãos a encontrar cursos de capacitação.

**Observação inicial:** candidatos têm dificuldade para localizar cursos adequados. As informações estão espalhadas por diferentes organizações e nem sempre são fáceis de comparar.

Isso é um ponto de partida, não um diagnóstico completo. Ainda é necessário descobrir quais informações faltam, quais barreiras são mais frequentes e como as pessoas procuram cursos hoje.

## Entregável

**Registro do contexto:** descrição do processo atual, dificuldades observadas, limitações e dúvidas pendentes.

## Critério para avançar

Você consegue explicar como a situação funciona hoje, quais dificuldades são reais e quais informações ainda precisam ser investigadas.

---

# 2. Identificar as partes interessadas (*stakeholders*)

## Objetivo

Descobrir quem utiliza, influencia, financia, mantém ou é afetado pela solução. Um sistema pode funcionar tecnicamente e ainda falhar porque ignora as necessidades de um grupo importante.

**Analogia:** construir uma biblioteca exige considerar leitores, bibliotecários, gestores, equipe de manutenção e responsáveis pelo acervo. Cada grupo tem necessidades diferentes.

## Quem pode ser uma parte interessada?

- **Usuários diretos:** utilizam o sistema no dia a dia.
- **Pessoas afetadas:** sentem os efeitos do sistema, mesmo sem utilizá-lo diretamente.
- **Gestores e financiadores:** definem prioridades, orçamento e resultados esperados.
- **Equipe técnica:** desenvolve, testa, opera e mantém a solução.
- **Responsáveis por regras e conformidade:** verificam obrigações legais, privacidade, segurança e políticas.
- **Parceiros externos:** fornecem dados, serviços ou integrações.

## Perguntas orientadoras

- [ ] Quem usará a solução?
- [ ] Quem será afetado pelas decisões do sistema?
- [ ] Quem define as prioridades?
- [ ] Quem fornece ou valida os dados?
- [ ] Quem dará suporte e fará a manutenção?
- [ ] Existem grupos com necessidades conflitantes?
- [ ] Quem deve aprovar os resultados?

## Exemplo — Cidadão Conectado

Possíveis partes interessadas:

| Parte interessada | Necessidade ou responsabilidade |
|---|---|
| Candidatos | Encontrar cursos relevantes e compreender os critérios de seleção |
| Atendentes | Ajudar pessoas que tenham dificuldade em usar a plataforma |
| Gestores | Acompanhar procura, encaminhamentos e resultados |
| Instrutores | Divulgar informações corretas sobre os cursos |
| Equipe de desenvolvimento | Implementar e manter o sistema |
| Responsáveis pela proteção de dados | Verificar o tratamento adequado de informações pessoais |
| Organizações que oferecem cursos | Manter vagas, requisitos e horários atualizados |

## O que fazer

1. Liste os grupos envolvidos.
2. Registre o que cada grupo precisa e espera.
3. Identifique quem pode validar requisitos e decisões.
4. Planeje como ouvir os grupos mais afetados.
5. Registre divergências em vez de presumir que todos querem a mesma coisa.

## Entregável

**Mapa de stakeholders:** grupos envolvidos, interesses, responsabilidades e formas de participação.

## Critério para avançar

Os grupos relevantes foram identificados, suas necessidades iniciais estão registradas e existe uma forma de validar essas necessidades.

---

# 3. Formular o problema

## Objetivo

Transformar observações em uma definição clara do problema que a solução deverá enfrentar. Uma formulação precisa evita desenvolver funcionalidades atraentes, mas irrelevantes.

**Analogia:** “preciso de uma ferramenta” descreve uma possível solução. “Demoro duas horas para localizar e conferir os dados” descreve um problema que pode ser investigado.

## Uma boa formulação deve indicar

- **Situação atual:** o que acontece hoje?
- **Público afetado:** quem enfrenta a dificuldade?
- **Barreira:** por que a situação é problemática?
- **Consequência:** o que a dificuldade provoca?
- **Resultado desejado:** o que precisa melhorar?
- **Limites:** o que o projeto não pretende resolver?

## Modelo para preencher

> Atualmente, **[público]** enfrenta **[problema observável]** em **[contexto]**, porque **[barreira ou causa conhecida]**. Isso resulta em **[consequência]**. O projeto pretende **[resultado desejado]**, dentro de **[limites e restrições]**.

Se a causa ainda não estiver comprovada, registre-a como hipótese, não como fato.

## Exemplo — Cidadão Conectado

> Atualmente, candidatos têm dificuldade para comparar oportunidades de capacitação porque as informações sobre cursos, requisitos e vagas estão distribuídas entre diferentes organizações. Isso pode dificultar a escolha e atrasar o encaminhamento. O projeto pretende centralizar e facilitar a consulta dessas informações, começando por um conjunto delimitado de cursos e organizações.

Observe que o texto descreve a dificuldade e o resultado esperado sem decidir antecipadamente todos os detalhes técnicos.

## Perguntas orientadoras

- [ ] O problema está descrito de forma específica?
- [ ] Há evidências ou exemplos que o sustentam?
- [ ] O público afetado está definido?
- [ ] A consequência da situação é compreensível?
- [ ] O resultado desejado pode ser observado?
- [ ] O escopo inicial é realista?
- [ ] Estamos descrevendo o problema, e não apenas uma solução favorita?

## Entregável

**Declaração do problema:** um parágrafo claro, validável e delimitado.

## Critério para avançar

Uma pessoa que não participou das conversas consegue entender o problema, quem é afetado e o que o projeto pretende melhorar.

---

# 4. Levantar requisitos

## Objetivo

Definir o que a solução deve fazer e quais condições de qualidade precisa cumprir. Requisitos transformam necessidades em expectativas que podem orientar o desenvolvimento e a avaliação.

## Dois grupos principais

### 4.1 Requisitos funcionais

Descrevem **o que o sistema deve fazer**.

Exemplos:

- cadastrar um curso;
- pesquisar cursos por área;
- exibir requisitos de inscrição;
- permitir que um gestor atualize a quantidade de vagas.

### 4.2 Requisitos não funcionais

Descrevem **como o sistema deve funcionar** ou quais restrições de qualidade deve respeitar.

Exemplos:

- proteger dados pessoais;
- responder às pesquisas dentro de um tempo definido;
- funcionar em dispositivos móveis;
- oferecer mensagens de erro compreensíveis;
- manter registros de alterações administrativas.

Sempre que possível, transforme termos vagos em critérios verificáveis. “Ser rápido” é vago; “exibir os resultados em até dois segundos em condições de teste definidas” é verificável.

## Perguntas orientadoras

- [ ] Quais tarefas o usuário precisa realizar?
- [ ] Quais dados entram, são processados e saem do sistema?
- [ ] Quais regras de negócio precisam ser respeitadas?
- [ ] Quais erros e situações excepcionais podem ocorrer?
- [ ] Quais requisitos de segurança, privacidade e acessibilidade existem?
- [ ] Como cada requisito será testado?
- [ ] O que é indispensável para a primeira versão (*MVP*)?

## Priorize o escopo

Uma classificação simples ajuda a controlar o tamanho da primeira versão:

- **Essencial:** sem isso, a solução não atende ao objetivo principal.
- **Importante:** agrega valor, mas pode entrar depois.
- **Futuro:** ideia válida que não precisa ser implementada agora.

## Modelo de requisito

| Campo | Exemplo |
|---|---|
| ID | RF-01 |
| Tipo | Funcional |
| Requisito | O sistema deve permitir pesquisar cursos por área |
| Prioridade | Essencial |
| Critério de aceitação | Ao selecionar uma área, o sistema apresenta apenas cursos compatíveis com o filtro |
| Validação | Teste com cursos de áreas diferentes |

## Entregável

**Lista de requisitos priorizados**, com critérios de aceitação e regras de negócio relevantes.

## Critério para avançar

Os requisitos essenciais estão claros, não apresentam contradições conhecidas e podem ser verificados por testes ou inspeção.

---

# 5. Modelar a solução

## Objetivo

Planejar a estrutura da solução antes de implementar os detalhes. A modelagem organiza dados, regras, responsabilidades, fluxos e integrações.

**Analogia:** uma planta arquitetônica define os espaços e suas relações antes da construção. Ela não substitui a obra, mas reduz improvisos e conflitos.

## O que modelar

- **Dados:** quais informações serão armazenadas e como se relacionam?
- **Regras de negócio:** quais condições determinam os resultados?
- **Classes e objetos:** quais conceitos e responsabilidades existem?
- **Fluxos:** quais passos ocorrem desde a entrada até a saída?
- **Interfaces:** como o usuário interage com o sistema?
- **Integrações:** quais sistemas externos serão consultados ou utilizados?
- **Critérios de decisão:** como o sistema escolhe ou classifica resultados?
- **Falhas:** o que acontece se os dados forem inválidos ou um serviço estiver indisponível?

## Escolha a representação adequada

| Necessidade | Recurso útil |
|---|---|
| Entender o processo | Fluxograma |
| Visualizar entidades e relações | Modelo de dados ou diagrama ER |
| Organizar responsabilidades em Java | Diagrama de classes |
| Descrever interação entre componentes | Diagrama de sequência |
| Definir regras e exceções | Tabela de decisão ou pseudocódigo |
| Planejar telas | Wireframe |
| Definir comunicação entre serviços | Contrato de API |

Não é necessário criar todos os diagramas em todo projeto. Escolha aqueles que esclarecem decisões importantes.

## Exemplo — Cidadão Conectado

Uma primeira modelagem pode identificar:

- **Curso:** nome, área, organização responsável, requisitos e vagas;
- **Organização:** nome, contato e cursos oferecidos;
- **Candidato:** dados estritamente necessários para a finalidade;
- **Regra de pesquisa:** filtrar cursos de acordo com a área selecionada.

Antes de implementar, a equipe ainda precisa definir validações, relacionamentos, permissões e tratamento de dados pessoais.

## Perguntas orientadoras

- [ ] Os dados necessários estão identificados?
- [ ] As regras de negócio estão explícitas?
- [ ] Cada classe ou módulo terá uma responsabilidade clara?
- [ ] Os fluxos principais e alternativos estão representados?
- [ ] As dependências e integrações estão identificadas?
- [ ] As falhas previsíveis têm tratamento definido?
- [ ] A solução pode evoluir sem exigir mudanças desnecessárias em todo o sistema?

## Entregável

**Modelo inicial da solução:** estruturas de dados, regras, responsabilidades e fluxos necessários para orientar a implementação.

## Critério para avançar

A equipe consegue explicar como a solução funcionará e como seus componentes colaborarão, sem depender de improvisação para as decisões centrais.

---

# 6. Implementar

## Objetivo

Transformar os requisitos e modelos em software executável. A implementação envolve código, testes, interfaces, documentação técnica e integração dos componentes.

**Princípio prático:** implemente primeiro o menor fluxo completo que demonstre o valor central da solução. Depois, amplie com segurança.

## Sequência recomendada

1. Prepare o ambiente, o repositório e as dependências.
2. Organize a estrutura do projeto e as responsabilidades dos módulos.
3. Implemente uma funcionalidade essencial por vez.
4. Valide entradas e trate erros previsíveis.
5. Escreva testes desde o início, não apenas no final.
6. Execute testes após cada mudança relevante.
7. Revise nomes, duplicação, legibilidade e complexidade.
8. Registre decisões importantes e atualize a documentação.

## Checklist de implementação

- [ ] O código segue convenções da linguagem e do projeto?
- [ ] Classes, funções e variáveis têm nomes claros?
- [ ] Cada componente tem responsabilidade definida?
- [ ] Entradas inválidas são tratadas?
- [ ] Erros não são ocultados silenciosamente?
- [ ] Segredos e credenciais estão fora do código versionado?
- [ ] Os testes cobrem o comportamento esperado e casos-limite?
- [ ] O projeto pode ser executado seguindo as instruções documentadas?
- [ ] As dependências e instruções de instalação estão registradas?

## Exemplo de evolução incremental

Em vez de construir toda a plataforma de uma vez:

1. carregar uma lista inicial de cursos;
2. pesquisar cursos por área;
3. validar resultados e filtros;
4. criar uma interface simples;
5. permitir a atualização dos dados;
6. adicionar autenticação e permissões, se necessárias ao escopo;
7. ampliar testes e documentação.

A ordem real depende dos requisitos e dos riscos. Funcionalidades sensíveis podem exigir controles de segurança desde a primeira versão.

## Entregável

**Versão executável da solução**, acompanhada de código organizado, testes e instruções de execução.

## Critério para avançar

O fluxo essencial funciona em condições conhecidas, os testes relevantes passam e outra pessoa consegue executar o projeto seguindo a documentação.

---

# 7. Avaliar

## Objetivo

Verificar se a solução funciona tecnicamente, atende ao problema original e pode ser utilizada com segurança e clareza.

**Distinção importante:** um programa pode executar sem erros e ainda não resolver o problema. Por isso, a avaliação deve verificar tanto o comportamento do software quanto o resultado para as pessoas.

## Dimensões da avaliação

### Funcionamento
- As funcionalidades cumprem os requisitos?
- Os cálculos e resultados estão corretos?
- Os casos-limite são tratados?

### Resolução do problema
- A dificuldade inicial foi reduzida?
- O resultado desejado pode ser medido?
- A solução oferece benefício real aos usuários?

### Segurança e privacidade
- Há controles de acesso adequados?
- Os dados pessoais são tratados de forma apropriada?
- Entradas maliciosas ou inesperadas são tratadas?
- Informações sensíveis podem vazar em logs ou relatórios?

### Usabilidade e acessibilidade
- As pessoas entendem como usar o sistema?
- Mensagens de erro ajudam a corrigir problemas?
- A interface é acessível ao público previsto?
- A solução funciona nos dispositivos e ambientes necessários?

### Efeitos indesejados
- Algum grupo é prejudicado ou excluído?
- Existem resultados injustos ou decisões difíceis de explicar?
- Há riscos operacionais, sociais ou financeiros?
- Os dados apresentados podem induzir decisões incorretas?

## Checklist de avaliação

- [ ] Requisitos funcionais verificados.
- [ ] Requisitos não funcionais avaliados.
- [ ] Testes de casos normais, inválidos e extremos executados.
- [ ] Segurança e privacidade revisadas conforme o risco.
- [ ] Usuários representativos participaram da validação, quando possível.
- [ ] Problemas encontrados foram registrados e priorizados.
- [ ] Existe uma decisão explícita: aprovar, corrigir ou adiar a entrega.

## Entregável

**Relatório de avaliação:** testes realizados, resultados, limitações, riscos conhecidos e correções necessárias.

## Critério para avançar

Há evidências suficientes de que a solução atende aos critérios definidos, e os riscos restantes foram avaliados e tratados de forma proporcional.

---

# 8. Melhorar continuamente

## Objetivo

Manter a solução útil, segura e adequada ao longo do tempo. Necessidades, dados, tecnologias, regras e comportamentos mudam; portanto, a entrega inicial não encerra o trabalho.

## O que acompanhar

- erros e falhas em produção;
- desempenho e disponibilidade;
- feedback dos usuários;
- indicadores relacionados ao problema original;
- mudanças nas regras de negócio;
- atualizações de dependências e vulnerabilidades;
- qualidade e atualidade dos dados;
- efeitos inesperados da solução.

## Ciclo de melhoria

1. **Monitorar:** coletar sinais de funcionamento e uso.
2. **Investigar:** descobrir causas, padrões e impactos.
3. **Priorizar:** comparar urgência, risco, benefício e esforço.
4. **Planejar:** definir a mudança e seus critérios de aceitação.
5. **Implementar:** alterar o sistema de forma controlada.
6. **Testar:** verificar o comportamento anterior e o novo.
7. **Avaliar novamente:** confirmar se a mudança produziu o resultado esperado.
8. **Documentar:** registrar decisões e atualizar instruções.

## Perguntas orientadoras

- [ ] O problema original continua existindo?
- [ ] Os indicadores mostram melhora ou regressão?
- [ ] Surgiram novas necessidades?
- [ ] Há vulnerabilidades ou dependências desatualizadas?
- [ ] Os usuários estão encontrando dificuldades?
- [ ] As alterações preservam funcionalidades já existentes?
- [ ] Há uma forma de reverter uma atualização problemática?

## Entregável

**Plano de evolução:** melhorias priorizadas, responsáveis, riscos, métricas e próximas ações.

## Critério de continuidade

A solução possui uma rotina proporcional de acompanhamento, correção e atualização. A etapa não termina definitivamente: ela alimenta um novo ciclo de compreensão e decisão.

---

# Ferramentas rápidas de consulta

## Problema, requisito e implementação: não confunda

| Conceito | Pergunta que responde | Exemplo |
|---|---|---|
| Problema | O que precisa melhorar? | Candidatos têm dificuldade para comparar cursos |
| Requisito | O que o sistema precisa fazer? | Permitir filtrar cursos por área |
| Modelo | Como a solução será organizada? | Definir dados de curso e regra de filtragem |
| Implementação | Como será construído? | Criar a função de filtro e a interface |
| Teste | Como verificaremos o comportamento? | Confirmar que só aparecem cursos da área selecionada |
| Avaliação | A solução trouxe o resultado esperado? | Verificar se a pesquisa ficou mais fácil e eficiente |
| Melhoria | O que deve evoluir? | Adicionar filtros com base no uso observado |

## Sinais de alerta

Pare e reavalie se:

- você está codificando sem conseguir explicar o problema;
- os requisitos mudam constantemente porque nunca foram esclarecidos;
- uma única classe ou função faz tarefas demais;
- o sistema depende de dados cuja origem ou qualidade é desconhecida;
- os testes só verificam o caminho ideal;
- “funciona na minha máquina” é a única evidência de funcionamento;
- não existe forma de descobrir se a solução realmente ajudou;
- ninguém é responsável por manutenção, segurança ou atualização.

## Como adaptar o ciclo ao tamanho do projeto

**Projeto pequeno ou exercício de estudo**
- Registre o problema em poucas linhas.
- Identifique o usuário e as regras principais.
- Modele apenas o necessário.
- Implemente um fluxo simples e teste casos-limite.
- Anote o que aprendeu e o que melhoraria.

**Projeto de portfólio**
- Documente problema, público, escopo e arquitetura.
- Defina requisitos e critérios de aceitação.
- Inclua testes, instruções de execução e limitações conhecidas.
- Demonstre o funcionamento com dados seguros e reproduzíveis.
- Registre melhorias futuras.

**Sistema usado por uma organização**
- Valide necessidades com os grupos envolvidos.
- Trate requisitos de segurança, privacidade, disponibilidade e auditoria.
- Planeje implantação, cópias de segurança, monitoramento e suporte.
- Defina responsáveis, procedimentos de recuperação e gestão de mudanças.
- Avalie impactos reais após a implantação.

---

# Folha de trabalho — aplique a um projeto real

Copie esta seção para cada projeto e preencha ao longo do desenvolvimento.

## Identificação
- **Nome do projeto:**
- **Responsável:**
- **Data / versão:**
- **Público principal:**

## 1. Contexto
- Onde o problema acontece?
- Como é resolvido atualmente?
- Quais fatos e evidências temos?
- Quais dúvidas precisam ser investigadas?

## 2. Partes interessadas
- Quem utilizará a solução?
- Quem será afetado?
- Quem valida requisitos e resultados?
- Quem manterá o sistema?

## 3. Problema
- Situação atual:
- Público afetado:
- Barreira principal:
- Consequência:
- Resultado desejado:
- Limites do projeto:

## 4. Requisitos
- Requisitos funcionais essenciais:
- Requisitos não funcionais:
- Regras de negócio:
- Critérios de aceitação:
- Fora do escopo desta versão:

## 5. Modelo
- Dados e entidades:
- Classes / módulos:
- Fluxo principal:
- Exceções e falhas:
- Integrações:
- Decisões técnicas pendentes:

## 6. Implementação
- [ ] Ambiente preparado
- [ ] Estrutura do projeto definida
- [ ] Fluxo essencial implementado
- [ ] Entradas e erros tratados
- [ ] Testes executados
- [ ] Documentação atualizada

## 7. Avaliação
- O que foi testado?
- Quais resultados foram obtidos?
- Quais riscos ou limitações permanecem?
- O que precisa ser corrigido antes da entrega?

## 8. Melhoria
- Indicadores a acompanhar:
- Feedback recebido:
- Próximas três melhorias:
  1.
  2.
  3.
- Como validar se cada melhoria funcionou?

---

# Resumo de bolso

Antes de codar, pergunte:

1. **Contexto:** entendi a situação real?
2. **Pessoas:** sei quem usa, decide e é afetado?
3. **Problema:** consigo descrever o que precisa melhorar?
4. **Requisitos:** sei o que é necessário e como verificar?
5. **Modelo:** defini dados, regras e responsabilidades?
6. **Implementação:** construí de forma incremental e testável?
7. **Avaliação:** há evidências de que funciona e ajuda?
8. **Melhoria:** sei como acompanhar e evoluir?

> **Uma boa solução computacional não é apenas código que executa. É uma resposta verificável a um problema real, construída com critérios claros e mantida de forma responsável.**
