package com.Software_Engineering.Software_Eng.dto;

<<<<<<< HEAD
=======
import com.Software_Engineering.Software_Eng.entity.IssueEntity;
>>>>>>> 94699e06d5c3e8d90d0e533efaa194ad7ed32ef5
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
<<<<<<< HEAD
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //모든 필드 생성자
public class IssueDTO {
    private Long i_id;
    private String issueWriter;
    private String issueContents;
    private String statement;
    private LocalDateTime issueCreatedTime;
=======
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
>>>>>>> 94699e06d5c3e8d90d0e533efaa194ad7ed32ef5
}
