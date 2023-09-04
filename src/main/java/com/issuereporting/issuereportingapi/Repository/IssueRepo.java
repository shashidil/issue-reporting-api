package com.issuereporting.issuereportingapi.Repository;

import com.issuereporting.issuereportingapi.Entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueRepo extends JpaRepository<Issue,Long> {

    List<Issue> findByStatusIdIn(List<Long> statusList);
}

