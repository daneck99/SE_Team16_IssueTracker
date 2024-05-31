package com.Software_Engineering.Software_Eng.dto;

import com.Software_Engineering.Software_Eng.entity.ComponentEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //모든 필드 생성자
public class ComponentDTO {
    private Long id;
    private String componentName;
    private Long projectId;

    public static ComponentDTO toComponentDTO(ComponentEntity componentEntity, Long projectId){
        ComponentDTO componentDTO = new ComponentDTO();
        componentDTO.setId(componentEntity.getId());
        componentDTO.setComponentName(componentEntity.getComponentName());
        componentDTO.setProjectId(projectId);
        return componentDTO;
    }
}
