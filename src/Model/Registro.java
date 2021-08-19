package Model;

import java.util.LinkedList;

/**
 *
 * @author Gonza
 */
public class Registro {

    private String id;
    private String clase;
    private int amb;
    private String tPar;
    private final LinkedList<Variable> params;
    private int linea;

    public Registro() {
        this.id = "";
        this.clase = "reg";
        this.amb = 0;
        this.tPar = "1";
        this.params = new LinkedList();
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public LinkedList<Variable> getParams() {
        return params;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getAmb() {
        return amb;
    }

    public void setAmb(int amb) {
        this.amb = amb;
    }

    public int getNoPar() {
        return this.getParams().size();
    }

    public String gettPar() {
        return tPar;
    }

    public void settPar(String tPar) {
        this.tPar = tPar;
    }

    @Override
    public String toString() {
        String para = "";
        para = params.stream().map(v -> "\n" + v.toString()).reduce(para, String::concat);
        return "ID: " + this.getId() + "\nClase: " + this.getClase()
                + "\nAmbito: " + this.getAmb() + "\nNoPar: " + this.getNoPar()
                + "\nTPar: " + this.gettPar() + "\nParametros: " + para;
    }

}
