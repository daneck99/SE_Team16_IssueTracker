package com.Software_Engineering.Software_Eng.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "issue_table")
public class IssueEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "reporter_id")
    private MemberEntity issueReporter;

    @Column(length = 500)
    private String issueContents;

    @Column
    private String statement;

    @OneToOne
    @JoinColumn(name = "fixer_id")
    private MemberEntity fixer;

}
