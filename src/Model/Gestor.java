package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Gonza
 */
public class Gestor {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement pst;
    private final Connect Connect = new Connect();
    private String sql;

    public void BorrarTodo() {
        con = Connect.abrir();
        try {
            sql = "DELETE FROM DATOS";
            pst = con.prepareCall(sql);
            if (pst.executeUpdate() > 0) {
                cerrar();
            } else {
                cerrar();
            }
        } catch (SQLException e) {
            System.out.println("Error al resert: " + e);
        }
    }

    public boolean guadarV(Datos d) {
        con = Connect.abrir();
        try {
            do {
                sql = "INSERT INTO DATOS (TIPO, ID, AMBITO, EXPANSION, VALOR) VALUES (?,?,?,?,?)";
                pst = con.prepareCall(sql);
                pst.setString(1, d.getTipo());
                pst.setString(2, d.getId().getFirst());
                pst.setInt(3, d.getAmbito());
                pst.setInt(4, d.getExpansion());
                pst.setString(5, d.getValor());
                if (pst.executeUpdate() > 0) {
                    d.getId().removeFirst();
                } else {
                    System.out.println("Error al guardar");
                    cerrar();
                    return false;
                }
            } while (!d.getId().isEmpty());
        } catch (SQLException e) {
            System.out.println(e);
        }
        cerrar();
        return d.getId().isEmpty();
    }

    public boolean eliminarAmbito(int ambito) {
        con = Connect.abrir();
        try {
            sql = "DELETE FROM DATOS WHERE AMBITO = ?";
            pst = con.prepareCall(sql);
            pst.setInt(1, ambito);
            if (pst.executeUpdate() > 0) {
                cerrar();
                return true;
            } else {
                cerrar();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el ambito: " + e);
        }
        cerrar();
        return false;
    }

    public boolean existe(String id, int ambito) {
        con = Connect.abrir();
        try {
            sql = "SELECT * FROM DATOS WHERE ID = ? AND AMBITO = ?";
            pst = con.prepareCall(sql);
            pst.setString(1, id);
            pst.setInt(2, ambito);
            rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Erorr al buscar la id: " + e);
        }
        cerrar();
        return false;
    }

    private void cerrar() {
        if (con != null) {
            con = Connect.cerrar();
        }
    }

}
