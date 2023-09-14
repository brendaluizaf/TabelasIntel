public class Computadores extends CadastroEmpresa {
    static String mouse;
    static String monitor;

    public Computadores(String nome, String descricao, String tipo, String mouse, String monitor) {
        super(nome, descricao, tipo);
        Computadores.mouse = mouse;
        Computadores.monitor = monitor;
    }

    public static String getMouse() {
        return mouse;
    }

    public static String getMonitor() {
        return monitor;
    }
}
