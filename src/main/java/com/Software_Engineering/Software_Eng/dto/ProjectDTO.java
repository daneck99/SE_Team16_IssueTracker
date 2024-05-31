package com.Software_Engineering.Software_Eng.dto;

import com.Software_Engineering.Software_Eng.entity.ProjectEntity;
import lombok.*;

import java.util.List;

//DTO(Data Transfer Object)
@Getter
@Setter
@ToString
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //모든 필드 생성자
public class ProjectDTO {
    private Long id;
    private String projectName;

    public static ProjectDTO toProjectDTO(ProjectEntity projectEntity){
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectName(projectEntity.getProjectName());
        return projectDTO;
    }
}
