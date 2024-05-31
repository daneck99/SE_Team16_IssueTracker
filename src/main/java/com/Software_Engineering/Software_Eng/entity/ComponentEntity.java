package com.Software_Engineering.Software_Eng.entity;

import com.Software_Engineering.Software_Eng.dto.ComponentDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name="component_table")
public class ComponentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String ComponentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectId")
    private ProjectEntity projectEntity;

    @OneToMany(mappedBy = "componentEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<IssueEntity> issueEntityList = new ArrayList<>();

    public static ComponentEntity toSaveComponentEntity(ComponentDTO componentDTO, ProjectEntity projectEntity){
        ComponentEntity componentEntity = new ComponentEntity();
        componentEntity.setComponentName(componentDTO.getComponentName());
        componentEntity.setProjectEntity(projectEntity);
        return componentEntity;
    }
}
