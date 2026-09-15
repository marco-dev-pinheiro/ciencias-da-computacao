import java.util.HashSet;
import java.util.Set;

public class Promocoes {
    public static void main(String[] args) {
  Set<String> codigosUtilizados = new HashSet<>();

  boolean primeiraInclusao = codigosUtilizados.add("PROMO10");
  boolean segundaInclusao = codigosUtilizados.add("PROMO10");

  System.out.println("Primeira inclusão: " + primeiraInclusao);
  System.out.println("Segunda inclusão: " + segundaInclusao);
  System.out.println("Códigos utilizados: " + codigosUtilizados);
    }
}
