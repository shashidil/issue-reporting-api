package com.issuereporting.issuereportingapi.Controller;

import com.issuereporting.issuereportingapi.Service.IssueStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/issue-report/status")
public class IssueStatusController {
    @Autowired
    private IssueStatusService issueStatusService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllItems() {
        return new ResponseEntity<>(issueStatusService.findAllIssueStatus(), HttpStatus.OK
        );
    }
}
