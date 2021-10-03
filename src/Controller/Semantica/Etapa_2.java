package Controller.Semantica;

/**
 *
 * @author Gonza
 */
public class Etapa_2 {
    
    public boolean Filtro(int clave, String tipo) {
        switch(clave) {
            case 1010: return tipo.equals("BOOL");
            case 1011: return tipo.equals("BOOL");
            case 1012: return tipo.equals("BOOL");
        }
        return false;
    }
    
}
