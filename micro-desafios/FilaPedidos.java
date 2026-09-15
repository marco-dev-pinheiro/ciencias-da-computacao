import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilaPedidos {
    public static void main(String[] args) {
        String[] pedidos = {
            "Pizza", "Hamburguer", "Sushi"
        };

        List<String> listaPedidos =
                new ArrayList<>(Arrays.asList(pedidos));

        System.out.println("Antes da remoção: " + listaPedidos);

        listaPedidos.removeIf(pedido -> pedido.equals("Sushi"));

        System.out.println("Depois da remoção: " + listaPedidos);
    }
}


