package com.issuereporting.issuereportingapi.Dto;

import com.issuereporting.issuereportingapi.Entity.IssueStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IssueDto {
    private String title;
    private String description;
    private IssueStatus status;

}
