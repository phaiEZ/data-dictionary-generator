package com.example.dataDictionary;
import org.apache.poi.xwpf.usermodel.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class createDocx {
    public static void createDocument() {
        XWPFDocument document = new XWPFDocument();

        // Create a table with 2 rows and 3 columns
        XWPFTable table = document.createTable(2, 3);

        // Set table width (optional)
        table.setWidth("100%");

        // Set table borders (optional)
        table.setTopBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 1, "000000");
        table.setBottomBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 1, "000000");
        table.setInsideHBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 1, "000000");
        table.setInsideVBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 1, "000000");

        // Set table cell content
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 3; col++) {
                XWPFTableCell cell = table.getRow(row).getCell(col);
                cell.setText("Row " + (row + 1) + ", Column " + (col + 1));
            }
        }

        // Save the document to a file
        try (FileOutputStream out = new FileOutputStream("example.docx")) {
            document.write(out);
            System.out.println("Document created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        createDocument();
    }

}
