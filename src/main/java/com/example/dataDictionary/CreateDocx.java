package com.example.dataDictionary;
import org.apache.poi.xwpf.usermodel.*;
import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;

public class createDocx {
    public static ResponseEntity<byte[]> createDocument(String[][][] tableDataList) {
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

            try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                document.write(out);
                System.out.println("Document created successfully!");

                byte[] fileContent = out.toByteArray();

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.setContentDispositionFormData("attachment", "file.docx");
                headers.setContentLength(fileContent.length);

                return ResponseEntity.ok()
                        .headers(headers)
                        .body(fileContent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.notFound().build();
    }
}