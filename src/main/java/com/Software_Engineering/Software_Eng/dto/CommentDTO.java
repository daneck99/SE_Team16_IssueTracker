package com.Software_Engineering.Software_Eng.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor//기본 생성자 생성 노테이션
@AllArgsConstructor // 모든 필드를 가지는 생성자 생성 노테이션
@ToString //
public class CommentDTO {
    private Long id;
    private String text;
    private Long issueId;
}
