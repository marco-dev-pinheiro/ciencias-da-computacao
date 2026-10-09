import java.util.Scanner;

public class MaiorValorSimples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[5];

        // 1. Passo: Coletar os dados
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            numeros[i] = scanner.nextInt();
        }

        // 2. Passo: Hipótese (O primeiro é o maior por enquanto)
        int maiorValor = numeros[0];
        int indiceMaior = 0;

        // 3. Passo: Comparar com o restante da lista (começa do índice 1)
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maiorValor) {
                maiorValor = numeros[i];
                indiceMaior = i;
            }
        }

        System.out.println("Maior valor: " + maiorValor);
        System.out.println("Posição (índice): " + indiceMaior);
    }
}