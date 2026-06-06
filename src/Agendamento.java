public class Agendamento implements Agendavel {
    private static int contador = 1;

    private String id;
    private String cliente;
    private String funcionario;
    private String servico;
    private double valorServico;
    private String data;
    private String status;

    public Agendamento(String cliente, String funcionario, String servico, double valorServico, String data) {
        this.id = "AG" + String.format("%03d", contador++);
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.servico = servico;
        this.valorServico = valorServico;
        this.data = data;
        this.status = "AGENDADO";
    }

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

    private static void atualizarContador(String id) {
        try {
            int numero = Integer.parseInt(id.replace("AG", ""));
            if (numero >= contador) contador = numero + 1;
        } catch (NumberFormatException e) {
            // Mantem o contador atual se o ID salvo estiver em formato invalido.
        }
    }

    public String getId() { return id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getValorServico() { return valorServico; }

    @Override
    public String resumo() {
        return id + " | " + cliente + " | " + funcionario + " | " + servico
             + " | " + data + " | " + status + " | R$ " + String.format("%.2f", valorServico);
    }

    @Override
    public String toString() { return resumo(); }
}
