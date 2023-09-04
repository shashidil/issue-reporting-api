package com.issuereporting.issuereportingapi.Service.Impl;

import com.issuereporting.issuereportingapi.Entity.IssueStatus;
import com.issuereporting.issuereportingapi.Repository.IssueStatusRepo;
import com.issuereporting.issuereportingapi.Service.IssueStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueStatusServiceImpl implements IssueStatusService {
    @Autowired
    private IssueStatusRepo issueStatusRepo;
    @Override
    public List<IssueStatus> findAllIssueStatus() {
        return issueStatusRepo.findAll();
    }
}
