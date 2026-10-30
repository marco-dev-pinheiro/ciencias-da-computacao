numeros = [int(input(f"Digite o {i + 1}º número: ")) for i in range(5)]

maior_valor = max(numeros)
indice_maior = numeros.index(maior_valor)

print(f"Maior valor: {maior_valor}")
print(f"Posição (índice): {indice_maior}")