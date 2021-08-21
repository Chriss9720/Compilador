package Model;

import java.util.LinkedList;

/**
 *
 * @author Gonza
 */
public class Variable extends Ids {

    private final LinkedList<String> id;
    
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
