public class CheckInService {

    // Método responsável pela regra de negócio
    public void realizarCheckIn(Hospede hospede, int numeroQuarto) {
        // 1. Verificação defensiva de segurança (evita NullPointerException)
        if (hospede == null) {
            throw new IllegalArgumentException("Dados do hóspede não fornecidos (objeto nulo).");
        }

        // 2. Validação de regra de negócio
        if (hospede.getIdade() < 18) {
            throw new IllegalArgumentException("Hóspede menor de 18 anos desacompanhado.");
        }

        // Se passou pelas validações, o fluxo segue seguro!
        System.out.println("Check-in de " + hospede.getNome() + " no quarto " + numeroQuarto + " efetuado!");
    }
}