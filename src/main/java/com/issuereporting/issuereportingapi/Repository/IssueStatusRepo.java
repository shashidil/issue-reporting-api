package com.issuereporting.issuereportingapi.Repository;

import com.issuereporting.issuereportingapi.Entity.IssueStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueStatusRepo extends JpaRepository<IssueStatus,Long> {

}
