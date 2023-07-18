package com.example.dataDictionary;

import org.apache.poi.xwpf.usermodel.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class createDocx {
    public static void createDocument(String[][][] tableDataList) {

        try (XWPFDocument document = new XWPFDocument()) {

            for (String[][] data : tableDataList) {
                String tableName = data[0][0];

                XWPFParagraph tableNameParagraph = document.createParagraph();
                XWPFRun tableNameRun = tableNameParagraph.createRun();
                tableNameRun.setText(tableName);
                tableNameParagraph.setSpacingAfter(200);

                XWPFTable table = document.createTable(data.length - 1, data[1].length);

                table.setWidth("100%");

                table.setTopBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 1, "000000");
                table.setBottomBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 1, "000000");
                table.setInsideHBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 1, "000000");
                table.setInsideVBorder(XWPFTable.XWPFBorderType.SINGLE, 1, 1, "000000");

                for (int row = 1; row < data.length; row++) {
                    for (int col = 0; col < data[row].length; col++) {
                        XWPFTableCell cell = table.getRow(row - 1).getCell(col);
                        cell.setText(data[row][col]);
                    }
                }

                XWPFParagraph space = document.createParagraph();
                space.setSpacingAfter(500);
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
}