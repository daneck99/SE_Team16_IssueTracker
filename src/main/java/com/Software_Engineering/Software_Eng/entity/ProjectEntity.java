package com.Software_Engineering.Software_Eng.entity;

import com.Software_Engineering.Software_Eng.dto.ComponentDTO;
import com.Software_Engineering.Software_Eng.dto.ProjectDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "project_table")

public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length= 30, nullable = false)
    private String projectName;


    @OneToMany(mappedBy = "projectEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ComponentEntity> componentEntityList= new ArrayList<>();

    public static ProjectEntity toProjectEntity(ProjectDTO projectDTO) {
        ProjectEntity projectEntity= new ProjectEntity();
        projectEntity.setProjectName(projectDTO.getProjectName());
        return projectEntity;
    }
}
