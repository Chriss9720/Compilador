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
        abrir();
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

    public Object[] gudarRegistro(Registro reg) {
        abrir();
        try {
            System.out.println(reg.gettPar());
            sql = "INSERT INTO ids(id, tipo, clase, amb, tarr, "
                    + "dimArr, noPar, tPar) values(?,?,?,?,?,?,?,?)";
            pst = con.prepareCall(sql);
            pst.setString(1, reg.getId());
            pst.setString(2, "");
            pst.setString(3, reg.getClase());
            pst.setString(4, tS(reg.getAmb()));
            pst.setString(5, "");
            pst.setString(6, "");
            pst.setString(7, tS(reg.getNoPar()));
            pst.setString(8, reg.gettPar());
            if (pst.executeUpdate() > 0) {
                cerrar();
                return guadarItemRegistro(reg.getParams());
            } else {
                System.out.println("Fallo al registrar");
            }
        } catch (Exception e) {
            System.out.println("Fallo al hacer el registro: " + e);
        }
        cerrar();
        return new Object[]{false, reg};
    }

    private Object[] guadarItemRegistro(LinkedList<Variable> lista) {
        abrir();
        try {
            int param = 1;
            do {
                do {
                    sql = "INSERT INTO ids(id, tipo, clase, amb, tarr, "
                            + "dimArr, noPar, tPar) values(?,?,?,?,?,?,?,?)";
                    pst = con.prepareCall(sql);
                    pst.setString(1, lista.getFirst().getId().getFirst());
                    pst.setString(2, lista.getFirst().getTipo());
                    pst.setString(3, lista.getFirst().getClase());
                    pst.setString(4, tS(lista.getFirst().getAmb()));
                    pst.setString(5, tS(lista.getFirst().gettArr()));
                    pst.setString(6, lista.getFirst().getDimArr());
                    pst.setString(7, tS(param));
                    pst.setString(8, lista.getFirst().gettPar());
                    if (pst.executeUpdate() > 0) {
                        lista.getFirst().getId().removeFirst();
                    } else {
                        cerrar();
                        return new Object[]{false, lista.getFirst()};
                    }
                    param++;
                } while (!lista.getFirst().getId().isEmpty());
                lista.removeFirst();
            } while (!lista.isEmpty());
            cerrar();
            return new Object[]{true};
        } catch (Exception e) {
            System.out.println("Fallo al registrar el parametro: " + e);
        }
        cerrar();
        return new Object[]{false, lista.getFirst()};
    }

    public Object[] guadarSimples(Variable v) {
        abrir();
        try {
            sql = "INSERT INTO ids(id, tipo, clase, amb, tarr, "
                    + "dimArr, noPar, tPar) values(?,?,?,?,?,?,?,?)";
            do {
                pst = con.prepareCall(sql);
                pst.setString(1, v.getId().getFirst());
                pst.setString(2, v.getTipo());
                pst.setString(3, v.getClase());
                pst.setString(4, tS(v.getAmb()));
                pst.setString(5, tS(v.gettArr()));
                pst.setString(6, v.getDimArr());
                pst.setString(7, tS(v.getNoPar()));
                pst.setString(8, v.gettPar());
                if (pst.executeUpdate() > 0) {
                    v.getId().removeFirst();
                } else {
                    return new Object[]{false, v};
                }
            } while (!v.getId().isEmpty());
            cerrar();
            return new Object[]{true};
        } catch (Exception e) {
            System.out.println("Fallo al guardarSimple: " + e);
        }
        cerrar();
        return new Object[]{false, v};
    }

    public boolean guardarConstante(Variable v) {
        abrir();
        try {
            sql = "INSERT INTO ids(id, tipo, clase, amb, tarr, "
                    + "dimArr, noPar, tPar) values(?,?,?,?,?,?,?,?)";
            pst = con.prepareCall(sql);
            pst.setString(1, v.getId().getFirst());
            pst.setString(2, v.getTipo());
            pst.setString(3, v.getClase());
            pst.setString(4, tS(v.getAmb()));
            pst.setString(5, tS(v.gettArr()));
            pst.setString(6, v.getDimArr());
            pst.setString(7, tS(v.getNoPar()));
            pst.setString(8, v.gettPar());
            boolean aux = (pst.executeUpdate() > 0);
            cerrar();
            return aux;
        } catch (Exception e) {
            System.out.println("Fallo al guardar la constante: " + v);
        }
        cerrar();
        return false;
    }

    public Object[] guardarFuncion(Funcion func) {
        abrir();
        try {
            sql = "INSERT INTO ids(id, tipo, clase, amb, tarr, "
                    + "dimArr, noPar, tPar) values(?,?,?,?,?,?,?,?)";
            pst = con.prepareCall(sql);
            pst.setString(1, func.getId());
            pst.setString(2, func.getTipo());
            pst.setString(3, func.getClase());
            pst.setString(4, tS(func.getAmb()));
            pst.setString(5, tS(func.gettArr()));
            pst.setString(6, func.getDimArr());
            pst.setString(7, tS(func.getNoPar()));
            pst.setString(8, func.gettPar());
            if (pst.executeUpdate() > 0) {
                cerrar();
                return guadarItemRegistro(func.getParams());
            } else {
                System.out.println("Fallo al registrar");
            }
        } catch (Exception e) {
            System.out.println("Fallo al registrar la funcion: " + e);
        }
        cerrar();
        return new Object[]{false, func};
    }

    public boolean existe(String id, LinkedList<Integer> amb) {
        abrir();
        boolean r = false;
        try {
            do {
                if (amb.isEmpty()) {
                    cerrar();
                    return false;
                }
                sql = "select * from ids where id = ? and amb = ?";
                pst = con.prepareCall(sql);
                pst.setString(1, id);
                pst.setString(2, tS(amb.getLast()));
                rs = pst.executeQuery();
                r = rs.next();
                amb.removeLast();
            } while (!r);
            cerrar();
        } catch (Exception e) {
            System.out.println("Fallo al verificar si existe: " + e);
        }
        cerrar();
        return r;
    }

    public boolean validarREG(String id, LinkedList<Integer> amb) {
        abrir();
        boolean r = false;
        try {
            do {
                if (amb.isEmpty()) {
                    cerrar();
                    return false;
                }
                sql = "select * from ids where id = ? and amb = ? and clase = ?";
                pst = con.prepareCall(sql);
                pst.setString(1, id);
                pst.setString(2, tS(amb.getLast()));
                pst.setString(3, "reg");
                rs = pst.executeQuery();
                r = rs.next();
                amb.removeLast();
            } while (!r);
        } catch (Exception e) {
            System.out.println("Error al buscar el reg: " + e);
        }
        cerrar();
        return r;
    }

    public int getTotal(int ambito, String tipo) {
        abrir();
        try {
            sql = "SELECT COUNT(*) AS TOTAL FROM ids WHERE tipo = ? AND amb = ?";
            pst = con.prepareCall(sql);
            pst.setString(1, tipo);
            pst.setString(2, tS(ambito));
            rs = pst.executeQuery();
            return rs.next() ? rs.getInt(1) : 0;
        } catch (Exception e) {
            System.out.println("Fallo al sacar el tipo: " + tipo + " del hambito: " + ambito + "\n" + e);
        }
        cerrar();
        return 0;
    }

    public int getTotalChar(int ambito) {
        abrir();
        try {
            sql = "select count(*) as total from ids where tipo like \"CHAR\""
                    + " and clase not like \"%arr%\""
                    + " and amb = ?;";
            pst = con.prepareCall(sql);
            pst.setString(1, tS(ambito));
            rs = pst.executeQuery();
            return rs.next() ? rs.getInt(1) : 0;
        } catch (Exception e) {
            System.out.println("Fallo al sacar el tipo: char del hambito: " + ambito + "\n" + e);
        }
        cerrar();
        return 0;
    }

    public int getTotalString(int ambito) {
        abrir();
        try {
            sql = "select count(*) as total from ids where tipo like \"char\""
                    + " and clase like \"%arr%\""
                    + " and amb = ?;";
            pst = con.prepareCall(sql);
            pst.setString(1, tS(ambito));
            rs = pst.executeQuery();
            return rs.next() ? rs.getInt(1) : 0;
        } catch (Exception e) {
            System.out.println("Fallo al sacar el tipo: char del hambito: " + ambito + "\n" + e);
        }
        cerrar();
        return 0;
    }

    public int totalTipoAmb(int amb) {
        abrir();
        try {
            sql = "select count(*) as total from ids where amb = ?;";
            pst = con.prepareCall(sql);
            pst.setString(1, tS(amb));
            rs = pst.executeQuery();
            return rs.next() ? rs.getInt(1) : 0;
        } catch (Exception e) {
            System.out.println("Fallo al sacar el total de datos: " + e);
        }
        cerrar();
        return 0;
    }

    public int totalRegistros(int amb) {
        abrir();
        try {
            sql = "select count(*) as total from ids where amb = ? and clase = \"reg\";";
            pst = con.prepareCall(sql);
            pst.setString(1, tS(amb));
            rs = pst.executeQuery();
            return rs.next() ? rs.getInt(1) : 0;
        } catch (Exception e) {
            System.out.println("Fallo al sacar el total de datos: " + e);
        }
        cerrar();
        return 0;
    }

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
