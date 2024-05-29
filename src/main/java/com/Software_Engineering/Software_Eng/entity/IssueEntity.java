package com.Software_Engineering.Software_Eng.entity;

<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "issue_table")
public class IssueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long i_id;

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

=======
import com.Software_Engineering.Software_Eng.dto.IssueDTO;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

// role of DB table
@Entity
@Getter
@Setter
@Table(name = "issue_table")
public class IssueEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String issueWriter;

    @Column
    private String issuePass;

    @Column
    private String issueTitle;

    @Column(length = 500)
    private String issueDescription;

    @OneToMany(mappedBy = "issueEntity", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CommentEntity> commentEntityList = new ArrayList<>();

    public static IssueEntity toSaveEntity(IssueDTO issueDTO){
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setIssueTitle(issueDTO.getIssueTitle());
        issueEntity.setIssuePass(issueDTO.getIssuePass());
        issueEntity.setIssueDescription(issueDTO.getIssueDescription());
        issueEntity.setIssueWriter(issueDTO.getIssueWriter());
        return issueEntity;
    }

    public static IssueEntity toUpdateEntity(IssueDTO issueDTO) {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setId(issueDTO.getId());
        issueEntity.setIssueTitle(issueDTO.getIssueTitle());
        issueEntity.setIssuePass(issueDTO.getIssuePass());
        issueEntity.setIssueDescription(issueDTO.getIssueDescription());
        issueEntity.setIssueWriter(issueDTO.getIssueWriter());
        return issueEntity;
    }
>>>>>>> 94699e06d5c3e8d90d0e533efaa194ad7ed32ef5
}
