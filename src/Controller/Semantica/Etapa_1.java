package Controller.Semantica;

import Model.Errores;
import Model.Variable;
import java.util.LinkedList;

/**
 *
 * @author Gonza
 */
public class Etapa_1 {

    private LinkedList<Variable> ids = new LinkedList();
    private LinkedList<String> operadores = new LinkedList();

    private final String[] entradas = new String[]{
        "INT", "REAL", "EXP", "CHAR", "CHAR[]", "BOOL", "REG", "VOID ", "FILE"};
    //Para la suma
    private final String[][] matrizSuma = new String[][]{
        {"INT", "REAL", "EXP", "INT", "CHAR[]", "ERROR", "REG", "ERROR", "ERROR"},
        {"REAL", "REAL", "EXP", "REAL", "CHAR[]", "ERROR", "REG", "ERROR", "ERROR"},
        {"EXP", "EXP", "EXP", "EXP", "CHAR[]", "ERROR", "REG", "ERROR", "ERROR"},
        {"INT", "REAL", "EXP", "INT", "CHAR[]", "ERROR", "REG", "ERROR", "ERROR"},
        {"CHAR[]", "CHAR[]", "CHAR[]", "CHAR[]", "CHAR[]", "CHAR[]", "REG", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "CHAR[]", "ERROR", "ERROR", "REG", "ERROR", "ERROR"},
        {"REG", "REG", "REG", "REG", "REG", "REG", "REG", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "REG", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "REG", "ERROR", "ERROR"}
    };
    //Para la resta
    private final String[][] matrizResta = new String[][]{
        {"INT", "REAL", "EXP", "INT", "ERROR", "ERROR", "REG", "ERROR", "ERROR"},
        {"REAL", "REAL", "EXP", "REAL", "ERROR", "ERROR", "REG", "ERROR", "ERROR"},
        {"EXP", "EXP", "EXP", "EXP", "ERROR", "ERROR", "REG", "ERROR", "ERROR"},
        {"INT", "REAL", "EXP", "INT", "ERROR", "ERROR", "REG", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "CHAR[]", "REG", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "CHAR[]", "ERROR", "ERROR", "REG", "ERROR", "ERROR"},
        {"REG", "REG", "REG", "REG", "REG", "REG", "REG", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"}
    };
    //Para multiplicacion
    private final String[][] matrizMultiplicacion = new String[][]{
        {"INT", "REAL", "EXP", "INT", "ERROR", "ERROR", "REG", "ERROR", "ERROR"},
        {"REAL", "REAL", "EXP", "REAL", "ERROR", "ERROR", "REG", "ERROR", "ERROR"},
        {"EXP", "EXP", "EXP", "EXP", "ERROR", "ERROR", "REG", "ERROR", "ERROR"},
        {"INT", "REAL", "EXP", "INT", "ERROR", "ERROR", "REG", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"REG", "REG", "REG", "REG", "ERROR", "ERROR", "REG", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"}
    };
    //Para divisiones
    private final String[][] matrizDiv = new String[][]{
        {"INT", "REAL", "EXP", "ERROR", "ERROR", "ERROR", "REG", "ERROR", "ERROR"},
        {"REAL", "REAL", "EXP", "ERROR", "ERROR", "ERROR", "REG", "ERROR", "ERROR"},
        {"EXP", "EXP", "EXP", "ERROR", "ERROR", "ERROR", "REG", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "REG", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"REG", "REG", "REG", "REG", "ERROR", "ERROR", "REG", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"}
    };
    //Para relacionales
    private final String[][] matrizRelacionales = new String[][]{
        {"BOOL", "BOOL", "BOOL", "BOOL", "BOOL", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"BOOL", "BOOL", "BOOL", "BOOL", "BOOL", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"BOOL", "BOOL", "BOOL", "BOOL", "BOOL", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"BOOL", "BOOL", "BOOL", "BOOL", "BOOL", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"BOOL", "BOOL", "BOOL", "BOOL", "BOOL", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"}
    };
    //Para logicos
    private final String[][] matrizLogicos = new String[][]{
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "BOOL", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"}
    };

    public void Reiniciar() {
        this.ids = new LinkedList();
        this.operadores = new LinkedList();
    }

    public void mostrarEcuacion() {
        String e = "";
        LinkedList<Variable> idsAux = new LinkedList();
        LinkedList<String> operadoresAux = new LinkedList();
        this.getIds().forEach(i -> idsAux.add(new Variable(i)));
        this.getOperadores().forEach(i -> operadoresAux.add(i));
        while (!idsAux.isEmpty()) {
            e += idsAux.getLast().getId().getFirst();
            if (!operadoresAux.isEmpty()) {
                e += " " + operadoresAux.getLast() + " ";
                operadoresAux.removeLast();
            }
            idsAux.removeLast();
        }
        System.out.println(e + " ->  SE_1");
    }

    public LinkedList<Errores> Resolver() {
        LinkedList<Errores> err = new LinkedList();
        String[] operador = new String[]{"/", "*", "+", "-", "<", ">=", "=>",
            "<=", "=<", "!=", ">", "=", "#", "&", "&&", "||", "|"};
        for (String i : operador) {
            buscarOperador(err, i);
        }
        igualar(err);
        return err;
    }

    private void igualar(LinkedList<Errores> err) {
        operadores.removeLast();
        String id1 = ids.getFirst().getId().getFirst();
        String id2 = ids.getLast().getId().getFirst();
        String t1 = ids.getFirst().getTipo();
        String t2 = ids.getLast().getTipo();
        int amb = ids.getFirst().getAmb();
        if (!ids.getLast().isVariant()) {
            if (!id2.equals(id1)) {
                int l = ids.getFirst().getLinea();
                String lex = id1 + "=" + id2;
                String msj = "No se puede igualar un: " + t1 + " a " + t2;
                err.add(new Errores(l, 806, lex, msj, "Semantica:Etapa 1", amb));
            }
        }
        while (!ids.isEmpty()) {
            ids.removeLast();
        }
    }

    private void buscarOperador(LinkedList<Errores> err, String op) {
        int p = buscar(op);
        while (p != -1) {
            ejecutar(p, err, op);
            p = buscar(op);
        }
    }

    private void ejecutar(int p, LinkedList<Errores> err, String c) {
        Variable v = new Variable();
        int t = 800;
        int aux = p + 1;
        boolean v1 = ids.get(p).isVariant();
        boolean v2 = ids.get(aux).isVariant();
        String id1 = ids.get(p).getId().getFirst();
        String id2 = ids.get(aux).getId().getFirst();
        String t1 = ids.get(p).getTipo();
        String t2 = ids.get(aux).getTipo();
        String tipo = "";
        String op = "";
        if (v1 || v2) {
            if (!v1 && v2) {
                tipo = t1;
                tipo(tipo, v, c, op, t);
            } else if (v1 && !v2) {
                tipo = t2;
                tipo(tipo, v, c, op, t);
            } else {
                v.setVariant(true);
            }
        } else {
            tipo(t1, t2, v, c, op, t);

        }
        if (v.getTipo().equals("ERROR")) {
            int l = ids.get(p).getLinea();
            int amb = ids.get(p).getAmb();
            String msj = "No se puede desarrollar una " + op + " de " + tipo;
            err.add(new Errores(l, t, id1 + c + id2, msj, "Semantica:Etapa 1", amb));
            v.setVariant(true);
        }
        ids.remove(aux);
        ids.remove(p);
        v.setId(id1);
        ids.add(p, v);
        operadores.remove(p);
    }

    private Variable tipo(String t1, String t2, Variable v, String c, String op, int t) {
        int fila = sacarFilaColumaMD(t1);
        int col = sacarFilaColumaMD(t2);
        ponerTipo(v, c, fila, col, op, t);
        return v;
    }

    private Variable tipo(String t1, Variable v, String c, String op, int t) {
        int fila = sacarFilaColumaMD(t1);
        int col = sacarFilaColumaMD(t1);
        ponerTipo(v, c, fila, col, op, t);
        return v;
    }

    private void ponerTipo(Variable v, String c, int fila, int col, String op, int t) {
        switch (c) {
            case "/":
                v.setTipo(matrizDiv[fila][col]);
                op = "division";
                t = 800;
                break;
            case "*":
                v.setTipo(matrizMultiplicacion[fila][col]);
                op = "multiplicacion";
                t = 801;
                break;
            case "+":
                op = "suma";
                t = 802;
                v.setTipo(matrizSuma[fila][col]);
                break;
            case "-":
                op = "resta";
                t = 803;
                v.setTipo(matrizResta[fila][col]);
                break;
            case "<":
            case ">=":
            case "=>":
            case "<=":
            case "=<":
            case "!=":
            case ">":
            case "="://igual o ==
                op = "relacional";
                t = 804;
                v.setTipo(matrizRelacionales[fila][col]);
                break;
            case "#":
            case "&":
            case "&&":
            case "||":
            case "|":
                op = "logicos";
                t = 805;
                v.setTipo(matrizLogicos[fila][col]);
                break;
        }
    }

    private int sacarFilaColumaMD(String in) {
        for (int i = 0; i < entradas.length; i++) {
            if (entradas[i].equals(in)) {
                return i;
            }
        }
        return -1;
    }

    private int buscar(String op) {
        LinkedList<String> aux = new LinkedList();
        operadores.forEach(i -> aux.add(i));
        while (!aux.isEmpty()) {
            if (aux.getLast().equals(op)) {
                return aux.size() - 1;
            }
            aux.removeLast();
        }
        return -1;
    }

    public LinkedList<Variable> getIds() {
        return ids;
    }

    public LinkedList<String> getOperadores() {
        return operadores;
    }

}
