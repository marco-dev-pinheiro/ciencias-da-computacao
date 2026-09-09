# 🔍 Detetive de Estruturas: Guia de Estudo e Investigação

> **Missão:** Rastreie a causa. Escolha o patch.  
> Investigue falhas em arrays e coleções Java antes que cheguem ao sistema real.

---

## 📂 Casos de Investigação

| Caso | Título | Problema Central |
| :--- | :--- | :--- |
| **Caso 01** | 🚨 **Índice fora da faixa** | Tentativa de acesso a posições inexistentes em um array ou lista (`ArrayIndexOutOfBoundsException`). |
| **Caso 02** | 🔄 **Alteração que não permanece** | Modificações feitas em cópias locais ou iteradores `for-each` sem afetar a estrutura original. |
| **Caso 03** | 🔎 **Busca sem preparação** | Aplicação de busca binária (`binarySearch`) em arrays ou coleções não ordenados. |
| **Caso 04** | 💥 **Remoção durante percurso** | Modificação de uma coleção enquanto ela é percorrida com `for-each` (`ConcurrentModificationException`). |
| **Caso 05** | 🎯 **Estrutura incompatível** | Uso de estruturas inadequadas para a regra de negócio (ex: permitir duplicatas quando se exige elementos únicos). |

---

## 📋 Protocolo de Investigação

Cada caso apresenta um trecho em Java, um sintoma e exige duas decisões: **identificar a falha** e **selecionar uma correção coerente**.

1. **Leia o código e o comportamento observado:** Analise a sintaxe Java e o erro/sintoma relatado.
2. **Marque uma hipótese de causa e um patch:** Selecione a causa-raiz provável e a solução adequada.
3. **Analise as evidências e reavalie:** Leia o feedback específico a cada tentativa e ajuste sua decisão se necessário.

---

## ⚙️ Regras do Jogo & Mecânicas

### 🏆 Pontuação
* **1ª Tentativa:** `100 pontos` *(Resolução perfeita)*
* **Tentativas Seguintes:** `60 pontos` *(Resolução com ajuste)*
* **Pontuação Máxima:** `500 pontos` (5 casos)

