// Cliente herda os dados de Pessoa.
public class Cliente extends Pessoa {
    // Construtor do cliente.
    public Cliente(String nome, String telefone) {
        super(nome, telefone);
    }

    // Tipo usado no toString da Pessoa.
    @Override
    public String getTipo() { return "CLIENTE"; }
}
