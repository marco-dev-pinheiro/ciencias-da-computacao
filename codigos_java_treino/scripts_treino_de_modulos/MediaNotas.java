import java.util.Scanner;

public class MediaNotas { 
  public static void main(String[] args) {
        calcularMedia();

  }
     public static float calcularMedia () {
        Scanner leitor_de_notas = new Scanner(System.in);
        
        System.out.print("Digite a primeira nota: ");
        float nota1 = leitor_de_notas.nextFloat();

        System.out.print("Digite a segunda nota: ");
        float nota2 = leitor_de_notas.nextFloat();

        System.out.print("Digite a terceira nota: ");
        float nota3 = leitor_de_notas.nextFloat();

        System.out.println("A média das notas é: " + String.format("%.2f", (nota1 + nota2 + nota3) / 3));

        return (nota1 + nota2 + nota3) / 3;
     }
}
