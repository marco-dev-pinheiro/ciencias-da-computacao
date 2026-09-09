import java.util.Arrays;

public class cardapio {
    public static void main(String[] args) {
        int [] codigos ={
            310, 101, 205
         };
        Arrays.sort(codigos);
        int posicao = Arrays.binarySearch(codigos, 205);
        System.out.println(posicao);  
    }
}
