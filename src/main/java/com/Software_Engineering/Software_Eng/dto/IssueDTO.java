package com.Software_Engineering.Software_Eng.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //모든 필드 생성자
public class IssueDTO {
    private Long i_id;
    private String issueWriter;
    private String issueContents;
    private String statement;
    private LocalDateTime issueCreatedTime;
}
