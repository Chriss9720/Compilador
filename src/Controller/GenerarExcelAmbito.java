package Controller;

import Model.Gestor;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

/**
 *
 * @author Gonza
 */
public class GenerarExcelAmbito {

    private Gestor gestor = new Gestor();
    private XSSFRow row;
    private XSSFCell cell;

    public GenerarExcelAmbito(LinkedList<Integer> ambitos) {
        generar(ambitos);
    }

    private void generar(LinkedList<Integer> ambitos) {
        String nombreArchivo = "src/Excel/18130159-Ambito.xlsx";
        XSSFWorkbook libro = new XSSFWorkbook();

        XSSFSheet hoja1 = libro.createSheet("Sintaxis-Ambito");
        String head[] = {"Ambito", "CHAR", "String (CHAR[])", "INT", "REAL",
            "BOOL", "EXP", "REG", "VOID", "FILE", "ERRORES", "Total de ambito"};
        row = hoja1.createRow(0);
        for (int i = 0; i < head.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(head[i]);
        }

        ambitos.forEach(amb -> {
            row = hoja1.createRow((amb + 1));
            int[] data = {amb, totalChar(amb), totalString(amb),
                total(amb, "INT"), total(amb, "REAL"), total(amb, "BOOL"),
                total(amb, "EXP"), registros(amb), total(amb, "VOID"),
                total(amb, "FILE"), 0, totalAmb(amb)};
            for (int i = 0; i < data.length; i++) {
                cell = row.createCell(i);
                cell.setCellValue(data[i]);
            }
        });

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
