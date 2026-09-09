public class LocalMaiorValor {
    public static void main(String[] args) {
        int[] numeros = {10, 40, 5, 30, 15};
        int maiorValor = numeros[0]; // Inicializa o maior valor com o primeiro elemento do array
        int indiceMaiorValor = 0; // Inicializa o índice do maior valor com 0

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maiorValor) {
                maiorValor = numeros[i];
                indiceMaiorValor = i;
            }
        }

        System.out.println("Maior valor: " + maiorValor);
        System.out.println("Índice do maior valor: " + indiceMaiorValor);
    }
}
