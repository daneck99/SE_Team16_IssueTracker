package com.Software_Engineering.Software_Eng.service;

import com.Software_Engineering.Software_Eng.dto.ComponentDTO;
import com.Software_Engineering.Software_Eng.entity.ComponentEntity;
import com.Software_Engineering.Software_Eng.entity.ProjectEntity;
import com.Software_Engineering.Software_Eng.repository.ComponentRepository;
import com.Software_Engineering.Software_Eng.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComponentService {
    private final ComponentRepository componentRepository;
    private final ProjectRepository projectRepository;

    public Long save(ComponentDTO componentDTO){
        // 부모 project 조회
        Optional<ProjectEntity> optionalProjectEntity =projectRepository.findById(componentDTO.getProjectId());
        if(optionalProjectEntity.isPresent()){
            ProjectEntity projectEntity = optionalProjectEntity.get();
            ComponentEntity componentEntity = ComponentEntity.toSaveComponentEntity(componentDTO,projectEntity);
            return componentRepository.save(componentEntity).getId();
        }else{
            return null;
        }
    }
    public List<ComponentDTO> findAll(Long projectId){
        ProjectEntity projectEntity = projectRepository.findById(projectId).get();
        List<ComponentEntity> componentEntityList = componentRepository.findAllByProjectEntityOrderByIdDesc(projectEntity);
        //EntityList -> DTOList
        List<ComponentDTO> componentDTOList = new ArrayList<>();
        for(ComponentEntity componentEntity:componentEntityList){
            ComponentDTO componentDTO = ComponentDTO.toComponentDTO(componentEntity,projectId);
            componentDTOList.add(componentDTO);
        }
        return componentDTOList;
    }
}
