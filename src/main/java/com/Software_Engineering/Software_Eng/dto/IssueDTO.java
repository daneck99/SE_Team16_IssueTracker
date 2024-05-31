package com.Software_Engineering.Software_Eng.dto;

import com.Software_Engineering.Software_Eng.entity.IssueEntity;
import com.Software_Engineering.Software_Eng.entity.ProjectEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //모든 필드 생성자
public class IssueDTO {
    private Long id;
    private Long issueReporter;
    private String issueContents;
    private String statement;
    private Long fixer;
    private LocalDateTime issueCreatedTime;

    public static IssueDTO toIssueDTO(IssueEntity issueEntity){
        IssueDTO issueDTO = new IssueDTO();
        issueDTO.setIssueContents(issueEntity.getIssueContents());
        issueDTO.setStatement(issueEntity.getStatement());
        //보류
        issueDTO.setFixer(issueEntity.getFixer());
        issueDTO.setIssueReporter(issueDTO.getIssueReporter());
        return issueDTO;
    }
}
