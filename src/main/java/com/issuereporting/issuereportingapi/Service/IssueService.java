package com.issuereporting.issuereportingapi.Service;

import com.issuereporting.issuereportingapi.Dto.IssueDto;
import com.issuereporting.issuereportingapi.Dto.SearchIssueDto;
import com.issuereporting.issuereportingapi.Entity.Issue;

import java.util.List;

public interface IssueService {
   IssueDto saveIssue(IssueDto issueDto);


    public List<Issue> findAllIssue();

    public List<IssueDto> findAllIssueByStatus(SearchIssueDto searchIssueDto);

    void deleteIssue(long id);

    IssueDto updateIssue(IssueDto issueDto, long id);

    public Issue findIssueById(long id);
}
