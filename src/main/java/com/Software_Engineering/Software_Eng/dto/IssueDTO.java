package com.Software_Engineering.Software_Eng.dto;

import com.Software_Engineering.Software_Eng.entity.IssueEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IssueDTO {
    private Long id;
    private String issueWriter;
    private String issueTitle;
    private String issuePass;
    private String issueDescription;
    private LocalDateTime issueCreatedTime;
    private LocalDateTime issueUpdatedTime;

    public IssueDTO(Long id, String issueTitle, String issueWriter, LocalDateTime issueCreatedTime) {
        this.id = id;
        this.issueTitle = issueTitle;
        this.issueWriter = issueWriter;
        this.issueCreatedTime = issueCreatedTime;
    }

    public static IssueDTO toIssueDTO(IssueEntity issueEntity) {
        IssueDTO issueDTO = new IssueDTO();
        issueDTO.setId(issueEntity.getId());
        issueDTO.setIssueWriter(issueEntity.getIssueWriter());
        issueDTO.setIssueTitle(issueEntity.getIssueTitle());
        issueDTO.setIssuePass(issueEntity.getIssuePass());
        issueDTO.setIssueDescription(issueEntity.getIssueDescription());
        issueDTO.setIssueCreatedTime(issueEntity.getCreatedTime());
        issueDTO.setIssueUpdatedTime(issueEntity.getUpdatedTime());
        return issueDTO;
    }
}
