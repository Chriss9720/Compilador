package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gonza
 */
public class Connect {

    private Connection con;
    private final String bd = "ok", usuario = "root", passw = "root",
            ulr = "jdbc:mysql://localhost/" + bd + "?useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Connection abrir() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(ulr, usuario, passw);
            System.out.println("Conexcion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexcion: " + e);
        }
        return con;
    }

    public Connection cerrar() {
        try {
            if (con != null) {
                con.close();
                System.out.println("Se cerro la conexion");
            }
        } catch (SQLException e) {
            System.out.println("No se cerro la conexcion " + e);
        }
        return con;
    }
}
