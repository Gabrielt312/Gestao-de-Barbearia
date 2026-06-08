// Classe base para Cliente e Funcionario.
public abstract class Pessoa {
    // Dados da pessoa.
    private String nome;
    private String telefone;

    // Construtor da pessoa.
    public Pessoa(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    // Getter do nome.
    public String getNome() { return nome; }

    // Setter do nome.
    public void setNome(String nome) { this.nome = nome; }

    // Getter do telefone.
    public String getTelefone() { return telefone; }

    // Setter do telefone.
    public void setTelefone(String telefone) { this.telefone = telefone; }

    // Cada filho informa se e cliente ou funcionario.
    public abstract String getTipo();

    // Texto que aparece quando listar ou salvar.
    @Override
    public String toString() {
        return getTipo() + " | " + nome + " | " + telefone;
    }
}
