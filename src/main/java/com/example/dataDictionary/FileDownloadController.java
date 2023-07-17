package com.example.dataDictionary;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class FileDownloadController {

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile() throws IOException {
        ClassPathResource resource = new ClassPathResource("templates/file.docx");
        byte[] fileContent = Files.readAllBytes(Path.of(resource.getURI()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "Sample_Revision_Sheet.docx");
        headers.setContentLength(fileContent.length);

        return ResponseEntity.ok().headers(headers).body(fileContent);
    }
}
