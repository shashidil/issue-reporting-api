package com.issuereporting.issuereportingapi.Service;

import com.issuereporting.issuereportingapi.Entity.IssueStatus;

import java.util.List;

public interface IssueStatusService {
    public List<IssueStatus> findAllIssueStatus();
}
