// Classe do agendamento.
public class Agendamento implements Agendavel {
    // Usado para criar IDs automaticos.
    private static int contador = 1;

    // Dados do agendamento.
    private String id;
    private String cliente;
    private String funcionario;
    private String servico;
    private double valorServico;
    private String data;
    private String status;

    // Construtor para agendamento novo.
    public Agendamento(String cliente, String funcionario, String servico, double valorServico, String data) {
        this.id = "AG" + String.format("%03d", contador++);
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.servico = servico;
        this.valorServico = valorServico;
        this.data = data;
        this.status = "AGENDADO";
    }

    // Construtor usado quando carrega do arquivo.
    public Agendamento(String id, String cliente, String funcionario, String servico,
                       double valorServico, String data, String status) {
        this.id = id;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.servico = servico;
        this.valorServico = valorServico;
        this.data = data;
        this.status = status;
        atualizarContador(id);
    }

    // Atualiza o contador para nao repetir ID.
    private static void atualizarContador(String id) {
        try {
            int numero = Integer.parseInt(id.replace("AG", ""));
            if (numero >= contador) contador = numero + 1;
        } catch (NumberFormatException e) {
            // Se o ID estiver errado, deixa o contador como esta.
        }
    }

    // Getter do contador.
    public static int getContador() { return contador; }

    // Setter do contador.
    public static void setContador(int contador) { Agendamento.contador = contador; }

    // Getter do ID.
    public String getId() { return id; }

    // Setter do ID.
    public void setId(String id) {
        this.id = id;
        atualizarContador(id);
    }

    // Getter do cliente.
    public String getCliente() { return cliente; }

    // Setter do cliente.
    public void setCliente(String cliente) { this.cliente = cliente; }

    // Getter do funcionario.
    public String getFuncionario() { return funcionario; }

    // Setter do funcionario.
    public void setFuncionario(String funcionario) { this.funcionario = funcionario; }

    // Getter do servico.
    public String getServico() { return servico; }

    // Setter do servico.
    public void setServico(String servico) { this.servico = servico; }

    // Getter do valor.
    public double getValorServico() { return valorServico; }

    // Setter do valor.
    public void setValorServico(double valorServico) { this.valorServico = valorServico; }

    // Getter da data.
    public String getData() { return data; }

    // Setter da data.
    public void setData(String data) { this.data = data; }

    // Getter do status.
    public String getStatus() { return status; }

    // Setter do status.
    public void setStatus(String status) { this.status = status; }

    // Resumo que aparece na listagem.
    @Override
    public String resumo() {
        return id + " | " + cliente + " | " + funcionario + " | " + servico
             + " | " + data + " | " + status + " | R$ " + String.format("%.2f", valorServico);
    }

    // Texto usado para listar e salvar.
    @Override
    public String toString() { return resumo(); }
}
