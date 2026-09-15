# 📦 Desafio: Sistema de Estoque CodeMarket

## 📌 Contexto
Estudos em Análise e Desenvolvimento de Sistemas. Refatoração e conclusão do sistema de estoque da CodeMarket.

##  Objetivos e Requisitos
- [v] Registrar produtos e validar quantidades.
- [v] Percorrer arrays identificando estoque baixo.
- [v] Organizar tarefas em métodos reutilizáveis.
- [v] Tratar entradas inválidas.

## 🧠 Planejamento (Foco no Aprendizado)
* **Interface Segura:** Implementar um **menu numérico interativo** (ex: `1 - Cadastrar`, `2 - Buscar`) no console em vez de inputs de texto, prevenindo erros de digitação pelo usuário.
* **Validação:** Criar métodos específicos (ex: `validar_quantidade()`) que bloqueiem números negativos ou nulos.
* **Modularidade:** Separar a lógica de busca do menu principal.

## 🧪 Casos de Teste (Documentação Viva)
- [v] Tentar cadastrar um produto com quantidade `-5`.
- [v] Escolher uma opção inválida no menu numérico (ex: `9`).
- [v] Adicionar produto com 2 unidades e verificar se o alerta de estoque baixo dispara ao percorrer o array.
