public class SistemaOperacional extends CadastroEmpresa {
    static String fabricante;
    static String anoLancamento;

    public SistemaOperacional(String nome, String descricao, String tipo, String fabricante, String anoLancamento) {
        super(nome, descricao, tipo);
        SistemaOperacional.fabricante = fabricante;
        SistemaOperacional.anoLancamento = anoLancamento;
    }

    public static String getFabricante() {
        return fabricante;
    }

    public static String getAno() {
        return anoLancamento;
    }

}
