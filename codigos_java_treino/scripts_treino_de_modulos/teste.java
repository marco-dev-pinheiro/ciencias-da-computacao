public class teste {

    public static void main(String[] args) {

        String[] produtos = {

            "Teclado",

            "Mouse",

            "Monitor",

            "Fone",

            "Webcam"

        };

        int[] quantidades = {10, 4, 7, -2, 8};

        int total = 0;

        for (int quantidade : quantidades){

            total = total + quantidade;

        }

        System.out.println("Total de itens: " + total);

    }

}