// Funcionario tambem herda Pessoa, mas tem especialidade.
public class Funcionario extends Pessoa {
    // Dado proprio do funcionario.
    private String especialidade;

    // Construtor do funcionario.
    public Funcionario(String nome, String telefone, String especialidade) {
        super(nome, telefone);
        this.especialidade = especialidade;
    }

    // Getter da especialidade.
    public String getEspecialidade() { return especialidade; }

    // Setter da especialidade.
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    // Tipo usado no toString da Pessoa.
    @Override
    public String getTipo() { return "FUNCIONARIO"; }

    // Mostra os dados do funcionario com a especialidade.
    @Override
    public String toString() {
        return super.toString() + " | " + especialidade;
    }
}
