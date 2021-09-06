package Controller.Semantica;

import Model.Errores;
import Model.Variable;
import java.util.LinkedList;

/**
 *
 * @author Gonza
 */
public class Etapa_1 {

    private final String[] EntradasSumaRestaRelacionalesLogicos = new String[]{
        "INT", "REAL", "EXP", "CHAR", "CHAR[]", "BOOL", "REG", "VOID ", "FILE"};
    private final String[] EntradasMultiplicacionDivision = new String[]{"INT",
        "REAL", "EXP", "CHAR", "REG", "VOID ", "FILE"};
    //Para la suma
    private final String[][] matrizSuma = new String[][]{
        {"INT", "REAL", "EXP", "INT", "CHAR[]", "ERROR", "REG", "ERROR", "ERROR"},
        {"REAL", "REAL", "EXP", "REAL", "CHAR[]", "ERROR", "REG", "ERROR", "ERROR"},
        {"EXP", "EXP", "EXP", "EXP", "CHAR[]", "ERROR", "REG", "ERROR", "ERROR"},
        {"INT", "REAL", "EXP", "INT", "CHAR[]", "ERROR", "REG", "ERROR", "ERROR"},
        {"CHAR[]", "CHAR[]", "CHAR[]", "CHAR[]", "CHAR[]", "CHAR[]", "REG", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "REG", "ERROR", "ERROR"},
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
        {"INT", "REAL", "EXP", "INT", "REG", "ERROR", "ERROR"},
        {"REAL", "REAL", "EXP", "REAL", "REG", "ERROR", "ERROR"},
        {"EXP", "EXP", "EXP", "EXP", "REG", "ERROR", "ERROR"},
        {"INT", "REAL", "EXP", "INT", "REG", "ERROR", "ERROR"},
        {"REG", "REG", "REG", "REG", "REG", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"}
    };
    //Para divisiones
    private final String[][] matrizDiv = new String[][]{
        {"INT", "REAL", "EXP", "ERROR", "REG", "ERROR", "ERROR"},
        {"REAL", "REAL", "EXP", "ERROR", "REG", "ERROR", "ERROR"},
        {"EXP", "EXP", "EXP", "ERROR", "REG", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "REG", "ERROR", "ERROR"},
        {"REG", "REG", "REG", "REG", "REG", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"}
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
    //Lista de errores
    private LinkedList<Errores> err;
    //Variable Resivida
    private Variable var;

    private LinkedList<Errores> MetodoRealizar(Variable var, Variable var2, String operador) {
        
        return err;
    }
}
