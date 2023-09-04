package com.issuereporting.issuereportingapi.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "issue_status")
public class IssueStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;


    public IssueStatus(long id, String name ) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public IssueStatus() {

    }


    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
