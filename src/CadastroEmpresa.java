public class CadastroEmpresa {
    static String nome;
    static String descricao;
    static String tipo;

    public CadastroEmpresa(String nome, String descricao, String tipo) {
        CadastroEmpresa.nome = nome;
        CadastroEmpresa.descricao = descricao;
        CadastroEmpresa.tipo = tipo;
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Tipo: " + tipo);

    }

    public static String getNome() {
        return nome;
    }

    public static String getDescricao(){
        return descricao;
    }
    public static String getTipoCadastro() {
        return tipo;
    }
}
