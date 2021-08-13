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

    public boolean insertar(int[] v) {
        con = Connect.abrir();
        try {
            sql = "INSERT INTO UNO(ok, ok2) VALUES (?,?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1, v[0]);
            pst.setInt(2, v[1]);
            if (pst.executeUpdate() > 0) {
                cerrar();
                return true;
            } else {
                cerrar();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e);
        }
        cerrar();
        return false;
    }

    private void cerrar() {
        if (con != null) {
            con = Connect.cerrar();
        }
    }

    public LinkedList<int[]> all() {
        LinkedList<int[]> resultado = new LinkedList();
        con = Connect.abrir();
        try {
            sql = "SELECT * FROM OK.UNO";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                resultado.add(new int[]{rs.getInt(1), rs.getInt(2), rs.getInt(3)});
            }
        } catch (SQLException e) {
            System.out.println("Eror al selecionar todos: " + e);
        }
        con = Connect.cerrar();
        return resultado;
    }

}
