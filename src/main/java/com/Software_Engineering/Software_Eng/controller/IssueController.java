package com.Software_Engineering.Software_Eng.controller;

import com.Software_Engineering.Software_Eng.dto.IssueDTO;
import com.Software_Engineering.Software_Eng.service.IssueService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/component/{id}")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @GetMapping
    public ResponseEntity<List<IssueDTO>> getAllIssues(@RequestParam Long componentId) {
        return ResponseEntity.ok(issueService.getAllIssues(componentId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDTO> getIssueById(@PathVariable Long id) {
        return ResponseEntity.ok(issueService.getIssueById(id));
    }

    @PostMapping
    public ResponseEntity<IssueDTO> createIssue(@RequestParam Long componentId, @RequestBody IssueDTO issueDTO, Authentication authentication) {
        String username = authentication.getName();
        return ResponseEntity.ok(issueService.createIssue(componentId, issueDTO, username));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueDTO> updateIssue(@PathVariable Long id, @RequestBody IssueDTO issueDTO) {
        issueDTO.setId(id);
        return ResponseEntity.ok(issueService.updateIssue(issueDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIssue(@PathVariable Long id) {
        issueService.deleteIssue(id);
        return ResponseEntity.noContent().build();
    }
}