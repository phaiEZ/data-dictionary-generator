package com.example.dataDictionary;

import org.apache.poi.xwpf.usermodel.*;
import java.io.IOException;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;

public class createDocx {
    public static ResponseEntity<ByteArrayResource> createDocument(String[][][] tableDataList) {
        try (XWPFDocument document = new XWPFDocument()) {
            for (String[][] data : tableDataList) {
                // ... your existing code to create the tables

                XWPFParagraph space = document.createParagraph();
                space.setSpacingAfter(500);
            }

            try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                document.write(out);
                System.out.println("Document created successfully!");

                byte[] fileContent = out.toByteArray();
                ByteArrayResource resource = new ByteArrayResource(fileContent);

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.setContentDispositionFormData("attachment", "file.docx");
                headers.setContentLength(fileContent.length);

                return ResponseEntity.ok()
                        .headers(headers)
                        .body(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.notFound().build();
    }
}
