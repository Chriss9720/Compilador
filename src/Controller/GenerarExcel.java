package Controller;

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
 * @author Chriss Yañez
 */
public class GenerarExcel implements ActionListener {

    private final JTable contadores;
    private final JTable errores;
    private final JTable tokens;

    public GenerarExcel(JTable contadores, JTable errores, JTable tokens) {
        this.contadores = contadores;
        this.errores = errores;
        this.tokens = tokens;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ejecutar();
    }
    
    public void ejecutar() {
        String nombreArchivo = "src/Excel/resultados.xlsx";
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
            JOptionPane.showMessageDialog(null, "Error al crear el excel:\n" +ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
