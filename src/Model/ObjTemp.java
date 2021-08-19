package Model;

/**
 *
 * @author Gonza
 */
public class ObjTemp {

    private String tipo;
    private int amb;
    private int tArr;
    private String dimArr;
    private String clase;
    private String id;
    private int linea;

    public ObjTemp() {
        this.tipo = "";
        this.amb = 0;
        this.tArr = 0;
        this.dimArr = "";
        this.clase = "";
        this.id = "";
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

}
