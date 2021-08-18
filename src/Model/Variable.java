package Model;

import java.util.LinkedList;

/**
 *
 * @author Gonza
 */
public class Variable {

    private final LinkedList<String> id;
    private String tipo;
    private String clase;
    private int amb;
    private int tArr;
    private String dimArr;
    private int noPar;
    private String tPar;

    public Variable() {
        this.id = new LinkedList();
        this.tipo = "";
        this.clase = "";
        this.amb = 0;
        this.tArr = 0;
        this.dimArr = "";
        this.noPar = 0;
        this.tPar = "";
    }

    public LinkedList<String> getId() {
        return id;
    }

    public void setId(String id) {
        this.id.add(id);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public int getNoPar() {
        return noPar;
    }

    public void setNoPar(int noPar) {
        this.noPar = noPar;
    }

    public String gettPar() {
        return tPar;
    }

    public void settPar(String tPar) {
        this.tPar = tPar;
    }

    @Override
    public String toString() {
        String ids = "";
        ids = getId().stream().map(item -> item + " ").reduce(ids, String::concat);
        return "ID: " + ids + "\ntipo: " + this.getTipo()
                + "\nClase: " + this.getClase() + "\nAmb: " + this.getAmb()
                + "\nTarr: " + this.gettArr() + "\nDimArr: " + this.getDimArr()
                + "\nNoPar: " + this.getNoPar() + "\nTParr: " + this.gettPar()
                + "\n-----------------------------------------------------";
    }

}
