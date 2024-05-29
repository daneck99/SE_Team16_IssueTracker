package com.Software_Engineering.Software_Eng.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //모든 필드 생성자
public class ComponentDTO {
    private Long c_id;
    private String c_name;
}
