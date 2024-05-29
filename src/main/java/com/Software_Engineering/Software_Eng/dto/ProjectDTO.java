package com.Software_Engineering.Software_Eng.dto;

import lombok.*;

//DTO(Data Transfer Object)
@Getter
@Setter
@ToString
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //모든 필드 생성자
public class ProjectDTO {
    private Long p_id;
    private String p_name;
}
