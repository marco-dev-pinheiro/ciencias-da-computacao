public class Aplicacao {

    public static void main(String[] args) {
        CheckInService checkInService = new CheckInService();
        Hospede hospedeNulo = new Hospede("marco", 17); // Simulando entrada de dado ausente

        // Bloco de proteção para a chamada do método
        try {
            System.out.println("Iniciando processo de check-in...");
            checkInService.realizarCheckIn(hospedeNulo, 204);
            
        } catch (IllegalArgumentException e) {
            // Captura o alerta do método e trata a falha de forma graciosa
            System.out.println("[SISTEMA] Não foi possível concluir o check-in.");
            System.out.println("[MOTIVO] " + e.getMessage());
        } finally {
            System.out.println("Atendimento finalizado no terminal.");
        }
    }
}
