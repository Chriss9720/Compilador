package Controller;

import Model.Ambito;
import Model.Gestor;
import Vista.Pantalla;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

/**
 *
 * @author Chriss Yañez
 */
public class GenerarExcel {

    private final JTable contadores;
    private final JTable errores;
    private final JTable tokens;
    private final LinkedList<Ambito> ambitos;
    private final Gestor gestor = new Gestor();

    public GenerarExcel(Pantalla p) {
        this.contadores = p.getContadores();
        this.errores = p.getErrores();
        this.tokens = p.getTokens();
        this.ambitos = p.getAmb();
    }

    public void ejecutar() {
        String nombreArchivo = "src/Excel/18130159.xlsx";
        XSSFWorkbook libro = new XSSFWorkbook();

        XSSFSheet hoja1 = libro.createSheet("Tokens");
        String[] head = {"Estado", "Lexema", "Linea"};
        XSSFRow row = hoja1.createRow(0);
        XSSFCell cell;
        for (int i = 0; i < head.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(head[i]);
        }
        for (int i = 0, j = 1; i < tokens.getModel().getRowCount(); i++, j++) {
            row = hoja1.createRow(j);
            cell = row.createCell(0);
            cell.setCellValue(String.valueOf(tokens.getValueAt(i, 0)));
            cell = row.createCell(1);
            cell.setCellValue(String.valueOf(tokens.getValueAt(i, 1)));
            cell = row.createCell(2);
            cell.setCellValue(String.valueOf(tokens.getValueAt(i, 2)));
        }

        XSSFSheet hoja2 = libro.createSheet("Errores");
        head = new String[]{"Token", "Descripción", "Lexema", "Tipo", "Linea"};
        row = hoja2.createRow(0);
        for (int i = 0; i < head.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(head[i]);
        }
        for (int i = 0, j = 1; i < errores.getModel().getRowCount(); i++, j++) {
            row = hoja2.createRow(j);
            cell = row.createCell(0);
            cell.setCellValue(String.valueOf(errores.getValueAt(i, 0)));
            cell = row.createCell(1);
            cell.setCellValue(String.valueOf(errores.getValueAt(i, 1)));
            cell = row.createCell(2);
            cell.setCellValue(String.valueOf(errores.getValueAt(i, 2)));
            cell = row.createCell(3);
            cell.setCellValue(String.valueOf(errores.getValueAt(i, 3)));
            cell = row.createCell(4);
            cell.setCellValue(String.valueOf(errores.getValueAt(i, 4)));
        }

        XSSFSheet hoja3 = libro.createSheet("Contadores");
        row = hoja3.createRow(0);
        for (int i = 0; i < contadores.getModel().getRowCount(); i++) {
            cell = row.createCell(i);
            cell.setCellValue(String.valueOf(contadores.getValueAt(i, 0)));
        }
        row = hoja3.createRow(1);
        for (int i = 0; i < contadores.getModel().getRowCount(); i++) {
            cell = row.createCell(i);
            cell.setCellValue(String.valueOf(contadores.getValueAt(i, 1)));
        }

        XSSFSheet hoja4 = libro.createSheet("Ambito");
        head = new String[]{"Ambito", "CHAR", "String (CHAR[])", "INT", "REAL",
            "BOOL", "EXP", "REG", "VOID", "FILE", "ERRORES", "Total de ambito"};
        row = hoja4.createRow(0);
        for (int i = 0; i < head.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(head[i]);
        }

        Object[] total = new Object[]{"Total", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (Ambito amb : ambitos) {
            int aux = amb.getAmbito();
            row = hoja4.createRow((aux + 1));
            int[] data = {aux, totalChar(aux), totalString(aux),
                total(aux, "INT"), total(aux, "REAL"), total(aux, "BOOL"),
                total(aux, "EXP"), registros(aux), total(aux, "VOID"),
                total(aux, "FILE"), amb.getErrores(), totalAmb(aux)};
            for (int i = 1; i < total.length; i++) {
                total[i] = tI(total[i]) + data[i];
            }
            for (int i = 0; i < data.length; i++) {
                cell = row.createCell(i);
                cell.setCellValue(data[i]);
            }
        }

        row = hoja4.createRow((ambitos.getLast().getAmbito() + 2));
        for (int i = 0; i < total.length; i++) {
            cell = row.createCell(i);
            if (i == 0) {
                cell.setCellValue(tS(total[0]));
            } else {
                cell.setCellValue(tI(total[i]));
            }
        }

        File file = new File(nombreArchivo);
        try (FileOutputStream fileOuS = new FileOutputStream(file)) {
            if (file.exists()) {
                file.delete();
            }
            libro.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();
            JOptionPane.showMessageDialog(null, "Excel creado exitosamente", "Excel", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al crear el excel:\n" + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int tI(Object o) {
        return Integer.parseInt(tS(o));
    }

    private String tS(Object o) {
        return String.valueOf(o);
    }

    private int registros(int amb) {
        return gestor.totalRegistros(amb);
    }

    private int totalAmb(int amb) {
        return (gestor.totalTipoAmb(amb));
    }

    private int total(int amb, String tipo) {
        return (gestor.getTotal(amb, tipo));
    }

    private int totalChar(int amb) {
        return (gestor.getTotalChar(amb));
    }

    private int totalString(int amb) {
        return (gestor.getTotalString(amb));
    }

}
