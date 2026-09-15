
import java.util.Arrays;

public class vendas {
    public static void main(String[] args) {
        int[] valores = {10, 20, 30};

        for (int i = 0; i < valores.length; i++) {
            valores[i] *= 2;
        }

        System.out.println(
        Arrays.toString(valores));
    }
       
}
