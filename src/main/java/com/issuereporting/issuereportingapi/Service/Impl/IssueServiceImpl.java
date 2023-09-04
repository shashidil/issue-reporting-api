package com.issuereporting.issuereportingapi.Service.Impl;

import com.issuereporting.issuereportingapi.Dto.IssueDto;
import com.issuereporting.issuereportingapi.Dto.SearchIssueDto;
import com.issuereporting.issuereportingapi.Entity.Issue;
import com.issuereporting.issuereportingapi.Entity.IssueStatus;
import com.issuereporting.issuereportingapi.Exception.IssueNotFoundException;
import com.issuereporting.issuereportingapi.Repository.IssueRepo;
import com.issuereporting.issuereportingapi.Repository.IssueStatusRepo;
import com.issuereporting.issuereportingapi.Service.IssueService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepo issueRepo;
    @Autowired
    private IssueStatusRepo issueStatusRepo;
    private ModelMapper modelMapper = new ModelMapper();


    @Override
    public IssueDto saveIssue(IssueDto issueDto) {
        Issue issue = new Issue();
        issue.setTitle(issueDto.getTitle());
        issue.setDescription(issueDto.getDescription());
        IssueStatus openStatus =  issueStatusRepo.findById(issueDto.getStatus().getId()).orElseThrow(() -> new IssueNotFoundException("Error: Issue is not found."));
        issue.setStatus(openStatus);
        Issue saved = issueRepo.save(issue);
        return modelMapper.map(saved,IssueDto.class);

    }



    @Override
    public List<Issue> findAllIssue() {
        List<Issue> issueList = issueRepo.findAll();
        if (issueList.isEmpty()){
            throw new IssueNotFoundException("Error: Issue is not found.");
        }
        return issueList;


    }

    @Override
    public List<IssueDto> findAllIssueByStatus(SearchIssueDto searchIssueDto) {
        List<Long> statusList = searchIssueDto.getStatusList().stream().map(Long::parseLong).collect(Collectors.toList());
        if (statusList.isEmpty()){
            List<Issue> allIssues=issueRepo.findAll();
            return allIssues.stream()
                    .map(this::convertToIssueDto)
                    .collect(Collectors.toList());
        }
        List<Issue> issuesByStatus=issueRepo.findByStatusIdIn(statusList);
        return issuesByStatus.stream()
                .map(this::convertToIssueDto)
                .collect(Collectors.toList());
    }
    @Override
    public void deleteIssue(long id) {
        Issue issueById = issueRepo.findById(id).orElseThrow(() -> new IssueNotFoundException("Error: Issue is not found."));
        issueRepo.deleteById(id);
    }

    @Override
    public IssueDto updateIssue(IssueDto issueDto) {
        Issue issue = new Issue();
        issue.setTitle(issueDto.getTitle());
        issue.setDescription(issueDto.getDescription());

        //issue.setStatus(new IssueStatus(issueDto.getStatus().getId(), issueDto.getStatus().getName()));
//        Issue saved = issueRepo.save(modelMapper.map(issueDto, Issue.class));
        IssueStatus openStatus =  issueStatusRepo.findById(issueDto.getStatus().getId()).orElseThrow(() -> new IssueNotFoundException("Error: Issue status is not found."));
        issue.setStatus(openStatus);
        Issue saved = issueRepo.save(issue);
        return modelMapper.map(saved,IssueDto.class);
    }

    @Override
    public Issue findIssueById(long id) {
        return issueRepo.findById(id).orElseThrow(() -> new IssueNotFoundException("Error: Issue is not found."));

    }


    private IssueDto convertToIssueDto(Issue issue) {
        return modelMapper.map(issue, IssueDto.class);
    }



}
