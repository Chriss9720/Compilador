package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            sql = "DELETE FROM ids";
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
//
//    public Object[] guardarRegistro(Registro reg) {
//        con = Connect.abrir();
//        try {
//            sql = "INSERT INTO ids(id, clase, amb, noPar, tPar) values (?,?,?,?,?)";
//            pst = con.prepareCall(sql);
//            pst.setString(1, reg.getId());
//            pst.setString(2, reg.getClase());
//            pst.setString(3, tS(reg.getAmb()));
//            pst.setString(4, reg.getNoPar());
//            pst.setString(5, tS(reg.gettParr()));
//            if (pst.executeUpdate() > 0) {
//                cerrar();
//                return registroParametros(reg);
//            } else {
//                cerrar();
//                return new Object[]{false, reg};
//            }
//        } catch (SQLException e) {
//            cerrar();
//            return new Object[]{false, reg};
//        }
//    }
//
//    public Object[] registroParametros(Registro reg) {
//        abrir();
//        try {
//            do {
//                Variables params = reg.getParams().getFirst();
//                do {
//                    String id = params.getId().getFirst();
//                    sql = "INSERT INTO ids(id, tipo, clase, amb, tarr, dimArr, noPar, tPar)"
//                            + " values (?,?,?,?,?,?,?,?)";
//                    pst = con.prepareCall(sql);
//                    pst.setString(1, id);
//                    pst.setString(2, params.getTipo());
//                    pst.setString(3, params.getClase());
//                    pst.setString(4, tS(params.getAmb()));
//                    pst.setString(5, params.gettArr());
//                    pst.setString(6, params.getDimArr());
//                    pst.setString(7, params.getNoPar());
//                    pst.setString(8, reg.getId());
//                    if (pst.executeUpdate() > 0) {
//                        params.getId().removeFirst();
//                    } else {
//                        System.out.println("Fallo al registrar un parametro");
//                        return new Object[]{false, params};
//                    }
//                } while (!params.getId().isEmpty());
//                reg.getParams().removeFirst();
//            } while (!reg.getParams().isEmpty());
//            return new Object[]{true};
//        } catch (Exception e) {
//            cerrar();
//            System.out.println("Fallo en el parametro: " + e);
//        }
//        cerrar();
//        return new Object[]{false, reg.getParams().getFirst()};
//    }

    private void abrir() {
        con = Connect.abrir();
    }

    private void cerrar() {
        if (con != null) {
            con = Connect.cerrar();
        }
    }

    private String tS(Object o) {
        return String.valueOf(o);
    }

}
