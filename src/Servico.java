// Classe dos servicos oferecidos.
public class Servico {
    // Dados do servico.
    private String nome;
    private double preco;

    // Construtor do servico.
    public Servico(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Getter do nome.
    public String getNome() { return nome; }

    // Setter do nome.
    public void setNome(String nome) { this.nome = nome; }

    // Getter do preco.
    public double getPreco() { return preco; }

    // Setter do preco.
    public void setPreco(double preco) { this.preco = preco; }

    // Texto usado para listar e salvar.
    @Override
    public String toString() {
        return nome + " | R$ " + String.format("%.2f", preco);
    }
}
