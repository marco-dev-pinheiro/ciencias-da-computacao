import java.util.Arrays;
import java.util.Scanner;

public class maiorIdade {
    public static void main(String[] args ) {
        int [] idades = new int[10];
        int somaIdades = 0; 
        int totalMaiores = 0;
        int totalMenores = 0;
        Scanner idadesScanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite a idade da pessoa " + (i + 1) + ": ");
            idades[i] = idadesScanner.nextInt();
            
            somaIdades += idades[i];

            if (idades[i] >= 18) {
                System.out.println("Pessoa " + (i + 1) + " é maior de idade.");
                totalMaiores++;
            } else {
                System.out.println("Pessoa " + (i + 1) + " é menor de idade.");
                totalMenores++;
                        }
                }
        Arrays.sort(idades);        
        System.out.println("Idades em ordem crescente: " + Arrays.toString(idades));
        System.out.println("Soma das idades: " + somaIdades);
        System.out.println("Total de pessoas maiores de idade: " + totalMaiores);
        System.out.println("Total de pessoas menores de idade: " + totalMenores);
    }
}