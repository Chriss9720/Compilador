package Model;

import java.util.LinkedList;

/**
 *
 * @author Gonza
 */
public class Datos {

    private final LinkedList<String> id;
    private String tipo;
    private int ambito;
    private int expansion;
    private String valor;
    private int linea;

    public Datos() {
        this.id = new LinkedList();
        tipo = "";
        ambito = 0;
        expansion = 0;
        valor = "";
        linea = 0;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getExpansion() {
        return expansion;
    }

    public void setExpansion(int expansion) {
        this.expansion = expansion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAmbito() {
        return ambito;
    }

    public void setAmbito(int ambito) {
        this.ambito = ambito;
    }

    public LinkedList<String> getId() {
        return id;
    }

    public void setId(String id) {
        this.id.add(id);
    }

    @Override
    public String toString() {
        String t = "";
        t = id.stream().map(i -> i + " ").reduce(t, String::concat);
        return "Tipo: " + getTipo()
                + "\nVariables " + t
                + "\nAmbito: " + getAmbito()
                + "\nExpansion: " + getExpansion()
                + "\nValor: " + getValor();
    }

}
