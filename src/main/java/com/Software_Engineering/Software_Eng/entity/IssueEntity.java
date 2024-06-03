package com.Software_Engineering.Software_Eng.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name= "issue_table")
public class IssueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String issueTitle;
    @Column
    private String issueContents;
    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "component_id")
    private ComponentEntity component;

    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEntity> comments;

    @Column(name= "fixer")
    private String fixerEmail;

    @Column(name = "reporter")
    private String reporterEmail;

}
