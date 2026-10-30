import java.util.HashMap;
import java.util.Map;

public class ComparaBusca {
    public static void main(String[] args) {
        int totalElementos = 1_000_000;
        String chaveProcurada = "ID_999999"; // Último elemento (pior caso para Array)

        // 1. Preenchimento do Array e do HashMap
        String[] arrayReservas = new String[totalElementos];
        Map<String, String> mapaReservas = new HashMap<>();

        for (int i = 0; i < totalElementos; i++) {
            String id = "ID_" + i;
            arrayReservas[i] = id;
            mapaReservas.put(id, "Reserva " + i);
        }

        // --- BUSCA NO ARRAY - O(n) ---
        long inicioArray = System.nanoTime(); // nanoTime é mais preciso para medir código rápido
        boolean encontradoArray = false;
        
        for (String item : arrayReservas) {
            if (item.equals(chaveProcurada)) {
                encontradoArray = true;
                break;
            }
        }
        long fimArray = System.nanoTime();
        double tempoArrayMs = (fimArray - inicioArray) / 1_000_000.0;

        // --- BUSCA NO HASHMAP - O(1) ---
        long inicioHash = System.nanoTime();
        boolean encontradoHash = mapaReservas.containsKey(chaveProcurada);
        long fimHash = System.nanoTime();
        double tempoHashMs = (fimHash - inicioHash) / 1_000_000.0;

        // Resultados
        System.out.println("Resultados para " + totalElementos + " elementos:");
        System.out.printf("Array (Busca Linear - O(n)): %.3f ms (Encontrado: %b)%n", tempoArrayMs, encontradoArray);
        System.out.printf("HashMap (Acesso Direto - O(1)): %.3f ms (Encontrado: %b)%n", tempoHashMs, encontradoHash);
    }
}

