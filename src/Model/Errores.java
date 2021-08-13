package Model;

/**
 *
 * @author Chriss Yañez
 */
public class Errores {

    private final int liena, numero;
    private final String lexema;
    private final String Desc;
    private final String tipo;

    public Errores(int liena, int numero, String lexema, String Desc, String tipo) {
        this.liena = liena;
        this.numero = numero;
        this.lexema = lexema;
        this.Desc = Desc;
        this.tipo = tipo;
    }

    public String getDesc() {
        return Desc;
    }

    public String getTipo() {
        return tipo;
    }

    public int getLiena() {
        return liena;
    }

    public int getNumero() {
        return numero;
    }

    public String getLexema() {
        return lexema;
    }
}
