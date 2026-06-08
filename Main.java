import java.util.ArrayList;
import java.util.Scanner;

// Classe principal do programa.
public class Main {

    // Nome dos arquivos.
    private static final String ARQ_CLIENTES = "clientes.txt";
    private static final String ARQ_FUNCIONARIOS = "funcionarios.txt";
    private static final String ARQ_SERVICOS = "servicos.txt";
    private static final String ARQ_AGENDAMENTOS = "agendamentos.txt";

    // Entrada de dados.
    private static Scanner sc = new Scanner(System.in);

    // Listas usadas no sistema.
    private static ArrayList<Cliente>     clientes     = new ArrayList<>();
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private static ArrayList<Servico>     servicos     = new ArrayList<>();
    private static ArrayList<Agendamento> agendamentos = new ArrayList<>();

    // Comeca o programa.
    public static void main(String[] args) {

        // Faz login antes de entrar no menu.
        boolean logado = false;
        while (!logado) logado = Login.entrar();

        // Carrega dados salvos.
        carregarTudo();

        int op;
        do {
            System.out.println("=== CABELEIREIRO ===");
            System.out.println("1. Clientes");
            System.out.println("2. Funcionarios");
            System.out.println("3. Servicos");
            System.out.println("4. Agendamentos");
            System.out.println("5. Relatorio");
            System.out.println("0. Sair");
            System.out.print("Opcao: ");
            op = sc.nextInt();

            // Escolhe o menu pela opcao.
            switch (op) {
                case 1: menuClientes();     break;
                case 2: menuFuncionarios(); break;
                case 3: menuServicos();     break;
                case 4: menuAgendamentos(); break;
                case 5: relatorio();        break;
                case 0: salvarTudo(); System.out.println("Ate logo!"); break;
                default: System.out.println("Invalido!\n");
            }
        } while (op != 0);
    }

    // =================== CLIENTES ===================

    // Menu dos clientes.
    static void menuClientes() {
        System.out.println("\n-- CLIENTES --");
        System.out.println("1. Cadastrar  2. Listar  3. Remover  0. Voltar");
        System.out.print("Opcao: ");
        int op = sc.nextInt();
        if (op == 1) cadastrarCliente();
        else if (op == 2) listar(clientes, "Clientes");
        else if (op == 3) remover(clientes, "cliente");
        System.out.println();
    }

    // Cadastra cliente.
    static void cadastrarCliente() {
        sc.nextLine();
        System.out.print("Nome: "); String nome = sc.nextLine();
        System.out.print("Telefone: "); String tel = sc.nextLine();
        clientes.add(new Cliente(nome, tel));
        System.out.println("Cliente cadastrado!");
    }

    // =================== FUNCIONARIOS ===================

    // Menu dos funcionarios.
    static void menuFuncionarios() {
        System.out.println("\n-- FUNCIONARIOS --");
        System.out.println("1. Cadastrar  2. Listar  3. Remover  0. Voltar");
        System.out.print("Opcao: ");
        int op = sc.nextInt();
        if (op == 1) cadastrarFuncionario();
        else if (op == 2) listar(funcionarios, "Funcionarios");
        else if (op == 3) remover(funcionarios, "funcionario");
        System.out.println();
    }

    // Cadastra funcionario.
    static void cadastrarFuncionario() {
        sc.nextLine();
        System.out.print("Nome: "); String nome = sc.nextLine();
        System.out.print("Telefone: "); String tel = sc.nextLine();
        System.out.print("Especialidade: "); String esp = sc.nextLine();
        funcionarios.add(new Funcionario(nome, tel, esp));
        System.out.println("Funcionario cadastrado!");
    }

    // =================== SERVICOS ===================

    // Menu dos servicos.
    static void menuServicos() {
        System.out.println("\n-- SERVICOS --");
        System.out.println("1. Cadastrar  2. Listar  3. Remover  0. Voltar");
        System.out.print("Opcao: ");
        int op = sc.nextInt();
        if (op == 1) cadastrarServico();
        else if (op == 2) listar(servicos, "Servicos");
        else if (op == 3) remover(servicos, "servico");
        System.out.println();
    }

    // Cadastra servico.
    static void cadastrarServico() {
        sc.nextLine();
        System.out.print("Nome do servico: "); String nome = sc.nextLine();
        System.out.print("Preco R$: "); double preco = sc.nextDouble();
        servicos.add(new Servico(nome, preco));
        System.out.println("Servico cadastrado!");
    }

    // =================== AGENDAMENTOS ===================

    // Menu dos agendamentos.
    static void menuAgendamentos() {
        System.out.println("\n-- AGENDAMENTOS --");
        System.out.println("1. Criar  2. Listar  3. Concluir  4. Cancelar  0. Voltar");
        System.out.print("Opcao: ");
        int op = sc.nextInt();
        if (op == 1) criarAgendamento();
        else if (op == 2) listar(agendamentos, "Agendamentos");
        else if (op == 3) mudarStatus("CONCLUIDO");
        else if (op == 4) mudarStatus("CANCELADO");
        System.out.println();
    }

    // Cria um agendamento.
    static void criarAgendamento() {
        if (clientes.isEmpty() || funcionarios.isEmpty() || servicos.isEmpty()) {
            System.out.println("Cadastre clientes, funcionarios e servicos antes de agendar.");
            return;
        }

        // Escolhe o cliente.
        listar(clientes, "Clientes");
        System.out.print("Numero do cliente: ");
        int ic = sc.nextInt() - 1;

        // Escolhe o funcionario.
        listar(funcionarios, "Funcionarios");
        System.out.print("Numero do funcionario: ");
        int ifun = sc.nextInt() - 1;

        // Escolhe o servico.
        listar(servicos, "Servicos");
        System.out.print("Numero do servico: ");
        int isv = sc.nextInt() - 1;

        sc.nextLine();
        System.out.print("Data (dd/mm/aaaa): ");
        String data = sc.nextLine();

        // Confere se os numeros existem.
        if (ic < 0 || ic >= clientes.size() || ifun < 0 || ifun >= funcionarios.size()
                || isv < 0 || isv >= servicos.size()) {
            System.out.println("Selecao invalida.");
            return;
        }

        // Junta cliente, funcionario e servico no agendamento.
        Agendamento ag = new Agendamento(
            clientes.get(ic).getNome(),
            funcionarios.get(ifun).getNome(),
            servicos.get(isv).getNome(),
            servicos.get(isv).getPreco(),
            data
        );
        agendamentos.add(ag);
        System.out.println("Agendamento criado! ID: " + ag.getId());
    }

    // Muda status para concluido ou cancelado.
    static void mudarStatus(String novoStatus) {
        listar(agendamentos, "Agendamentos");
        if (agendamentos.isEmpty()) return;
        System.out.print("Numero do agendamento: ");
        int idx = sc.nextInt() - 1;
        if (idx < 0 || idx >= agendamentos.size()) { System.out.println("Invalido."); return; }
        agendamentos.get(idx).setStatus(novoStatus);
        System.out.println("Status atualizado para: " + novoStatus);
    }

    // =================== RELATORIO ===================

    // Mostra o relatorio geral.
    static void relatorio() {
        System.out.println("\n=== RELATORIO GERAL ===");
        System.out.println("Clientes: "     + clientes.size());
        System.out.println("Funcionarios: " + funcionarios.size());
        System.out.println("Servicos: "     + servicos.size());
        System.out.println("Agendamentos: " + agendamentos.size());

        double receita = 0;
        int concluidos = 0, cancelados = 0;
        for (Agendamento ag : agendamentos) {
            if (ag.getStatus().equals("CONCLUIDO")) { receita += ag.getValorServico(); concluidos++; }
            if (ag.getStatus().equals("CANCELADO"))  cancelados++;
        }
        System.out.println("Concluidos: " + concluidos + " | Cancelados: " + cancelados);
        System.out.printf("Receita total: R$ %.2f%n%n", receita);
    }

    // =================== UTILITARIOS ===================

    // Lista qualquer lista recebida.
    static <T> void listar(ArrayList<T> lista, String titulo) {
        System.out.println("\n-- " + titulo + " --");
        if (lista.isEmpty()) { System.out.println("(vazio)"); return; }
        for (int i = 0; i < lista.size(); i++)
            System.out.println((i + 1) + ". " + lista.get(i));
    }

    // Remove um item da lista.
    static <T> void remover(ArrayList<T> lista, String tipo) {
        listar(lista, tipo);
        if (lista.isEmpty()) return;
        System.out.print("Numero para remover: ");
        int idx = sc.nextInt() - 1;
        if (idx >= 0 && idx < lista.size()) {
            lista.remove(idx);
            System.out.println("Removido com sucesso!");
        } else {
            System.out.println("Numero invalido.");
        }
    }

    // Salva todas as listas.
    static void salvarTudo() {
        Arquivos.salvar(ARQ_CLIENTES, clientes);
        Arquivos.salvar(ARQ_FUNCIONARIOS, funcionarios);
        Arquivos.salvar(ARQ_SERVICOS, servicos);
        Arquivos.salvar(ARQ_AGENDAMENTOS, agendamentos);
        System.out.println("Dados salvos.");
    }

    // Carrega todas as listas.
    static void carregarTudo() {
        clientes.clear();
        funcionarios.clear();
        servicos.clear();
        agendamentos.clear();

        // Lendo cada arquivo.
        for (String linha : Arquivos.carregar(ARQ_CLIENTES)) carregarCliente(linha);
        for (String linha : Arquivos.carregar(ARQ_FUNCIONARIOS)) carregarFuncionario(linha);
        for (String linha : Arquivos.carregar(ARQ_SERVICOS)) carregarServico(linha);
        for (String linha : Arquivos.carregar(ARQ_AGENDAMENTOS)) carregarAgendamento(linha);

        System.out.println("Dados carregados.");
    }

    // Transforma uma linha em Cliente.
    static void carregarCliente(String linha) {
        String[] partes = linha.split("\\s*\\|\\s*");
        if (partes.length >= 3)
            clientes.add(new Cliente(partes[1], partes[2]));
    }

    // Transforma uma linha em Funcionario.
    static void carregarFuncionario(String linha) {
        String[] partes = linha.split("\\s*\\|\\s*");
        if (partes.length >= 4)
            funcionarios.add(new Funcionario(partes[1], partes[2], partes[3]));
    }

    // Transforma uma linha em Servico.
    static void carregarServico(String linha) {
        String[] partes = linha.split("\\s*\\|\\s*");
        if (partes.length >= 2)
            servicos.add(new Servico(partes[0], lerPreco(partes[1])));
    }

    // Transforma uma linha em Agendamento.
    static void carregarAgendamento(String linha) {
        String[] partes = linha.split("\\s*\\|\\s*");
        if (partes.length >= 7) {
            agendamentos.add(new Agendamento(
                partes[0],
                partes[1],
                partes[2],
                partes[3],
                lerPreco(partes[6]),
                partes[4],
                partes[5]
            ));
        }
    }

    // Converte texto de preco para double.
    static double lerPreco(String texto) {
        String valor = texto.replace("R$", "").trim();
        if (valor.contains(",")) valor = valor.replace(".", "").replace(",", ".");
        return Double.parseDouble(valor);
    }

    // Getter do arquivo de clientes.
    public static String getArqClientes() { return ARQ_CLIENTES; }

    // Getter do arquivo de funcionarios.
    public static String getArqFuncionarios() { return ARQ_FUNCIONARIOS; }

    // Getter do arquivo de servicos.
    public static String getArqServicos() { return ARQ_SERVICOS; }

    // Getter do arquivo de agendamentos.
    public static String getArqAgendamentos() { return ARQ_AGENDAMENTOS; }

    // Getter dos clientes.
    public static ArrayList<Cliente> getClientes() { return clientes; }

    // Setter dos clientes.
    public static void setClientes(ArrayList<Cliente> clientes) { Main.clientes = clientes; }

    // Getter dos funcionarios.
    public static ArrayList<Funcionario> getFuncionarios() { return funcionarios; }

    // Setter dos funcionarios.
    public static void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        Main.funcionarios = funcionarios;
    }

    // Getter dos servicos.
    public static ArrayList<Servico> getServicos() { return servicos; }

    // Setter dos servicos.
    public static void setServicos(ArrayList<Servico> servicos) { Main.servicos = servicos; }

    // Getter dos agendamentos.
    public static ArrayList<Agendamento> getAgendamentos() { return agendamentos; }

    // Setter dos agendamentos.
    public static void setAgendamentos(ArrayList<Agendamento> agendamentos) {
        Main.agendamentos = agendamentos;
    }

    // Getter do Scanner.
    public static Scanner getSc() { return sc; }

    // Setter do Scanner.
    public static void setSc(Scanner sc) { Main.sc = sc; }

    // Texto da classe.
    @Override
    public String toString() {
        return "Main | Clientes: " + clientes.size()
             + " | Funcionarios: " + funcionarios.size()
             + " | Servicos: " + servicos.size()
             + " | Agendamentos: " + agendamentos.size();
    }
}
