public class Processador extends CadastroEmpresa {
    String nome;
    String descricao;
    String tipo;
    static String core;
    static String frequencia;

    public Processador(String nome, String descricao, String tipo, String core, String frequencia) {
        super(nome, descricao, tipo);
        Processador.core = core;
        Processador.frequencia = frequencia;
    }

    public static String getCore() {
        return core;
    }

    public static String getFrequencia() {
        return frequencia;
    }

}
