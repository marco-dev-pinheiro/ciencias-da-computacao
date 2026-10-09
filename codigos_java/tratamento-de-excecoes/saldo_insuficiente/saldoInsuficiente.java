// 1. Exceção de Domínio (Checked)
class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}

// 2. Regra de Negócio (Lança a exceção)
class Carteira {
    private double saldo = 320.0;

    public void pagar(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do pagamento deve ser maior que zero.");
        }
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo indisponível. Saldo atual: R$ " + saldo);
        }
        this.saldo -= valor;
    }
}

// 3. Camada de Aplicação (Trata a exceção)
class ModuloPagamento {
    public static void main(String[] args) {
        Carteira carteira = new Carteira();

        try {
            carteira.pagar(500.0);
            System.out.println("Pagamento efetuado com sucesso!");
        } catch (SaldoInsuficienteException e) {
            System.out.println("Aviso ao Cliente: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de entrada: " + e.getMessage());
        }
    }
}