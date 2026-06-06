public class Funcionario extends Pessoa {
    protected String especialidade;

    public Funcionario(String nome, String telefone, String especialidade) {
        super(nome, telefone);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() { return especialidade; }

    @Override
    public String getTipo() { return "FUNCIONARIO"; }

    @Override
    public String toString() {
        return super.toString() + " | " + especialidade;
    }
}
