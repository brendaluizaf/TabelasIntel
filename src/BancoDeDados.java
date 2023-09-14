import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDeDados {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Intel";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void criarComputador() {
        try (Connection conexao = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                Statement criar = conexao.createStatement()) {

            String createTableSQL = "CREATE TABLE IF NOT EXISTS Computadores(" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "nome VARCHAR(100)," +
                    "descricao VARCHAR(100)," +
                    "tipo VARCHAR(50)," +
                    "mouse VARCHAR(50)," +
                    "monitor VARCHAR(50)" +
                    ")";
            criar.executeUpdate(createTableSQL);
            System.out.println("Tabela 'Computadores' criada com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public static void criarProcessador() {
        try (Connection conexao = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                Statement criar = conexao.createStatement()) {

            String TabelaProcessador = "CREATE TABLE IF NOT EXISTS Processador(" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "nome VARCHAR(100)," +
                    "descricao VARCHAR(100)," +
                    "tipo VARCHAR(50)," +
                    "core VARCHAR(50)," +
                    "frequencia VARCHAR(50)" +
                    ")";
            criar.executeUpdate(TabelaProcessador);
            System.out.println("Tabela 'Processador' criada com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public static void criarSistema() {
        try (Connection conexao = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                Statement criar = conexao.createStatement()) {

            String TabelaSistema = "CREATE TABLE IF NOT EXISTS Sistema(" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "nome VARCHAR(100)," +
                    "descricao VARCHAR(100)," +
                    "tipo VARCHAR(50)," +
                    "fabricante VARCHAR(50)," +
                    "anoLancamento VARCHAR(50)" +
                    ")";
            criar.executeUpdate(TabelaSistema);
            System.out.println("Tabela 'Sistema' criada com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public static void InserirProcessador(Processador processador) {
        criarProcessador();

        try (Connection conexao = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                PreparedStatement Inserir = conexao
                        .prepareStatement(
                                "INSERT INTO Processador(nome, descricao, tipo, core, frequencia) VALUES (?, ?, ?, ?, ?)")) {
            Inserir.setString(1, CadastroEmpresa.getNome());
            Inserir.setString(2, CadastroEmpresa.getDescricao());
            Inserir.setString(3, CadastroEmpresa.getTipoCadastro());
            Inserir.setString(4, Processador.getCore());
            Inserir.setString(5, Processador.getFrequencia());
            Inserir.executeUpdate();
            System.out.println("O processador foi inserido no banco de dados.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir no banco de dados: " + e.getMessage());
        }
    }

    /*
     * public static void inserirCadastroEmpresa(CadastroEmpresa cadastro) {
     * 
     * try (Connection conexao = DriverManager.getConnection(JDBC_URL, USER,
     * PASSWORD);
     * PreparedStatement stmt = conexao
     * .prepareStatement("INSERT INTO Computadores(nome, descricao, tipo) VALUES (?, ?, ?)"
     * )) {
     * 
     * stmt.setString(1, cadastro.nome);
     * stmt.setString(2, cadastro.descricao);
     * stmt.setString(3, cadastro.getTipoCadastro());
     * 
     * stmt.executeUpdate();
     * System.out.println("O produto inserido no banco de dados.");
     * 
     * } catch (SQLException e) {
     * System.out.println("Erro ao inserir no banco de dados: " + e.getMessage());
     * }
     * }
     */
    public static void inserirComputadores(Computadores computador) {
        criarComputador();

        try (Connection conexao = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                PreparedStatement Inserir = conexao
                        .prepareStatement(
                                "INSERT INTO Computadores(nome, descricao, tipo, mouse, monitor) VALUES (?, ?, ?, ?, ?)")) {

            Inserir.setString(1, CadastroEmpresa.getNome());
            Inserir.setString(2, CadastroEmpresa.getDescricao());
            Inserir.setString(3, CadastroEmpresa.getTipoCadastro());
            Inserir.setString(4, Computadores.getMouse());
            Inserir.setString(5, Computadores.getMonitor());

            Inserir.executeUpdate();
            System.out.println("O produto inserido no banco de dados.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir no banco de dados: " + e.getMessage());
        }
    }

    public static void inserirSistema(SistemaOperacional sistema) {
        criarSistema();

        try (Connection conexao = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                PreparedStatement Inserir = conexao
                        .prepareStatement(
                                "INSERT INTO Sistema(nome, descricao, tipo, fabricante, anoLancamento) VALUES (?, ?, ?, ?, ?)")) {

            Inserir.setString(1, CadastroEmpresa.getNome());
            Inserir.setString(2, CadastroEmpresa.getDescricao());
            Inserir.setString(3, CadastroEmpresa.getTipoCadastro());
            Inserir.setString(4, SistemaOperacional.getFabricante());
            Inserir.setString(5, SistemaOperacional.getAno());

            Inserir.executeUpdate();
            System.out.println("O produto inserido no banco de dados.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir no banco de dados: " + e.getMessage());
        }
    }

    public static void ConsultaSistema() {
        try (
                Connection conexao = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                PreparedStatement consulta = conexao.prepareStatement("SELECT * FROM Sistema");
                ResultSet resultados = consulta.executeQuery()) {

            if (!resultados.next()) {
                System.out.println("Não há computadores cadastrados.");
            } else {
                do {
                    int id = resultados.getInt("id");
                    String nome = resultados.getString("nome");
                    String descricao = resultados.getString("descricao");
                    String tipo = resultados.getString("tipo");
                    String fabricante = resultados.getString("fabricante");
                    String anoLancamento = resultados.getString("anoLancamento");

                    System.out.println("Consulta Sistema:");
                    System.out.println("ID: " + id);
                    System.out.println("Nome: " + nome);
                    System.out.println("descricao: " + descricao);
                    System.out.println("tipo: " + tipo);
                    System.out.println("Fabricante: " + fabricante);
                    System.out.println("Ano de lançamento: " + anoLancamento);
                    System.out.println();
                } while (resultados.next());
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar: " + e.getMessage());
        }
    }

    public static void ConsultaProcessador() {
        try (
                Connection conexao = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                PreparedStatement consulta = conexao.prepareStatement("SELECT * FROM Processador");
                ResultSet resultados = consulta.executeQuery()) {

            if (!resultados.next()) {
                System.out.println("Não há computadores cadastrados.");
            } else {
                do {
                    int id = resultados.getInt("id");
                    String nome = resultados.getString("nome");
                    String descricao = resultados.getString("descricao");
                    String tipo = resultados.getString("tipo");
                    String core = resultados.getString("core");
                    String frequencia = resultados.getString("frequencia");

                    System.out.println("Consulta Processador:");
                    System.out.println("ID: " + id);
                    System.out.println("Nome: " + nome);
                    System.out.println("descricao: " + descricao);
                    System.out.println("tipo: " + tipo);
                    System.out.println("Fabricante: " + core);
                    System.out.println("Ano de lançamento: " + frequencia);
                    System.out.println();
                } while (resultados.next());
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar: " + e.getMessage());
        }
    }

    public static void ConsultaComputador() {

        try (
                Connection conexao = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                PreparedStatement consulta = conexao.prepareStatement("SELECT * FROM Computadores");
                ResultSet resultados = consulta.executeQuery()) {

            if (!resultados.next()) {
                System.out.println("Não há computadores cadastrados.");
            } else {
                do {
                    int id = resultados.getInt("id");
                    String nome = resultados.getString("nome");
                    String descricao = resultados.getString("descricao");
                    String tipo = resultados.getString("tipo");
                    String mouse = resultados.getString("mouse");
                    String monitor = resultados.getString("monitor");

                    System.out.println("Consulta Computador:");
                    System.out.println("ID: " + id);
                    System.out.println("Nome: " + nome);
                    System.out.println("descricao: " + descricao);
                    System.out.println("tipo: " + tipo);
                    System.out.println("Mouse: " + mouse);
                    System.out.println("Monitor: " + monitor);
                    System.out.println();
                } while (resultados.next());
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar: " + e.getMessage());
        }
    }
}
