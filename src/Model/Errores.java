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
    private int amb;

    public Errores(int liena, int numero, String lexema, String Desc, String tipo, int amb) {
        this.liena = liena;
        this.numero = numero;
        this.lexema = lexema;
        this.Desc = Desc;
        this.tipo = tipo;
        this.amb = amb;
    }

    public Errores(Errores err) {
        this.liena = err.getLiena();
        this.numero = err.getNumero();
        this.lexema = err.getLexema();
        this.Desc = err.getDesc();
        this.tipo = err.getTipo();
    }

    public int getAmb() {
        return amb;
    }

    public void setAmb(int amb) {
        this.amb = amb;
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
