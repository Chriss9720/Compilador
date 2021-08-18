package Model;

import java.util.LinkedList;

/**
 *
 * @author Gonza
 */
public class Funcion {

    private String id;
    private String clase;
    private String tipo;
    private int amb;
    private int tArr;
    private String dimArr;
    private String tPar;
    private final LinkedList<Variable> params;

    public Funcion() {
        this.id = "";
        this.clase = "funcion";
        this.amb = 0;
        this.tPar = "1";
        this.params = new LinkedList();
        this.tipo = "";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int gettArr() {
        return tArr;
    }

    public void settArr(int tArr) {
        this.tArr = tArr;
    }

    public String getDimArr() {
        return dimArr;
    }

    public void setDimArr(String dimArr) {
        this.dimArr = dimArr;
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
                + "\nTPar: " + this.gettPar() + "\nTipo: " + this.getTipo()
                + "\nDimArr: " + this.getDimArr() + "\nTArr: " + this.gettArr()
                + "\nParametros: " + para;
    }

}
