package com.example.dataDictionary;

import org.apache.poi.xwpf.usermodel.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class createDocx {
    public static void createDocument() {

        try (XWPFDocument document = new XWPFDocument()) {
            String[][][] tableData = {
                    {
                            { "Table Name" },
                            {"TableName","TableComment"},
                            {"table20", "This is table 20 comment."},
                            {"table20", "This is table 20 comment."},
                            {"table20", "This is table 20 comment."},
                            {"table20", "This is table 20 comment."},
                            {"table20", "This is table 20 comment."},
                            {"table20", "This is table 20 comment."},
                            {"table20", "This is table 20 comment."},
                    },
                    {
                            { "Table 1" },
                            { "COLUMN", "TYPE", "NULL", "DEFAULT", "COMMENT" },
                            { "column2", "type2", "true", "default_value2", "Comment for column2" },
                            { "column3", "type3", "true", "default_value3", "Comment for column3" },
                            { "column4", "type4", "false", "null", "Comment for column4" }
                    },
                    {
                            { "Table 2" },
                            { "COLUMN", "TYPE", "NULL", "DEFAULT", "COMMENT" },
                            { "column2", "type2", "true", "default_value2", "Comment for column2" },
                            { "column3", "type3", "true", "default_value3", "Comment for column3" },
                            { "column4", "type4", "false", "null", "Comment for column4" }
                    },
                    {
                            { "Table 3" },
                            { "COLUMN", "TYPE", "NULL", "DEFAULT", "COMMENT" },
                            { "column2", "type2", "true", "default_value2", "Comment for column2" },
                            { "column3", "type3", "true", "default_value3", "Comment for column3" },
                            { "column4", "type4", "false", "null", "Comment for column4" }
                    },
                    // Add more table data arrays as needed
            };

            for (String[][] data : tableData) {
                String tableName = data[0][0];

                // Create a paragraph for the table name
                XWPFParagraph tableNameParagraph = document.createParagraph();
                XWPFRun tableNameRun = tableNameParagraph.createRun();
                tableNameRun.setText(tableName); // Set the table name

                // Create a table after the table name
                XWPFTable table = document.createTable(data.length - 1, data[1].length);

                // Set table width (optional)
                table.setWidth("100%");

                // Set table borders (optional)
                table.setTopBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 1, "000000");
                table.setBottomBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 1, "000000");
                table.setInsideHBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 1, "000000");
                table.setInsideVBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 1, "000000");

                // Set table cell content
                for (int row = 1; row < data.length; row++) {
                    for (int col = 0; col < data[row].length; col++) {
                        XWPFTableCell cell = table.getRow(row - 1).getCell(col);
                        cell.setText(data[row][col]);
                    }
                }
            }

            String filePath = "src/main/resources/templates/file.docx";
            File file = new File(filePath);
            file.delete();

            try (FileOutputStream out = new FileOutputStream(filePath)) {
                document.write(out);
                System.out.println("Document created successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createDocument();
    }
}
