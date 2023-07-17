package com.example.dataDictionary;
import org.apache.poi.xwpf.usermodel.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class createDocx {
    public static void createDocument() {

        String[][] data = {
                {"COLUMN", "TYPE", "NULL", "DEFAULT", "COMMENT"},
                {"column2", "type2", "true", "default_value2", "Comment for column2"},
                {"column3", "type3", "true", "default_value3", "Comment for column3"},
                {"column4", "type4", "false", "null", "Comment for column4"}
        };

        XWPFDocument document = new XWPFDocument();

        // Create a table with 2 rows and 3 columns
        XWPFTable table = document.createTable(data.length, 5);

        // Set table width (optional)
        table.setWidth("100%");

        // Set table borders (optional)
        table.setTopBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 1, "000000");
        table.setBottomBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 1, "000000");
        table.setInsideHBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 1, "000000");
        table.setInsideVBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 1, "000000");

        // Set table cell content

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < 5; col++) {
                XWPFTableCell cell = table.getRow(row).getCell(col);
                cell.setText(data[row][col]);
            }
        }
        String filePath = "/resources/templates/file.docx";

        // Save the document to a file
        try (FileOutputStream out = new FileOutputStream(filePath)) {
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
