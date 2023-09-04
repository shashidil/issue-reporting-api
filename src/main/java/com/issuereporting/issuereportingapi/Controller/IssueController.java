package com.issuereporting.issuereportingapi.Controller;

import com.issuereporting.issuereportingapi.Dto.IssueDto;
import com.issuereporting.issuereportingapi.Dto.SearchIssueDto;
import com.issuereporting.issuereportingapi.Entity.Issue;
import com.issuereporting.issuereportingapi.Service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issue-report")
public class IssueController {
    @Autowired
    private IssueService issueService;


    @PostMapping("/new-issue")
    public ResponseEntity<?> saveIssue(@RequestBody IssueDto issueDto) {
        IssueDto SavedIssue = issueService.saveIssue(issueDto);
        if (null != SavedIssue) {
            return new ResponseEntity<>(("Issue Saved"), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(("Issue Not Saved"), HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateIssue(@RequestBody IssueDto issueDto, @PathVariable long id) {
        Issue existIssue = issueService.findIssueById(id);
        if (null != existIssue) {
            issueService.updateIssue(issueDto,id);
        }
        return new ResponseEntity<>("Updated issue ", HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllIssue() {
        List<Issue> allIssue = issueService.findAllIssue();
        return new ResponseEntity<>(allIssue, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getIssueById(@PathVariable long id) {
        return new ResponseEntity<>(issueService.findIssueById(id), HttpStatus.OK);
    }

    @GetMapping("/search-list")
    public ResponseEntity<?> getIssueByStatus(@RequestParam List<String> id) {
        SearchIssueDto searchIssueDto = new SearchIssueDto();
        searchIssueDto.setStatusList(id);
        return new ResponseEntity<>(issueService.findAllIssueByStatus(searchIssueDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIssue(@PathVariable long id) {
        issueService.deleteIssue(id);
        return new ResponseEntity<>(
                "Issue Deleted",
                HttpStatus.NO_CONTENT
        );
    }
}
