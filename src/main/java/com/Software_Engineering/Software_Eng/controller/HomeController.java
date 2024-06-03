package com.Software_Engineering.Software_Eng.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<byte[]> getHomePage() throws IOException {
        // 정적 HTML 파일을 읽어옴
        Resource resource = new ClassPathResource("static/index.html");
        byte[] htmlBytes = Files.readAllBytes(Path.of(resource.getURI()));

        // HTML 파일을 ResponseEntity로 래핑하여 반환
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(htmlBytes);
    }
}

