package com.Software_Engineering.Software_Eng.service;

import com.Software_Engineering.Software_Eng.dto.MemberDTO;
import com.Software_Engineering.Software_Eng.dto.ProjectDTO;
import com.Software_Engineering.Software_Eng.entity.MemberEntity;
import com.Software_Engineering.Software_Eng.entity.ProjectEntity;
import com.Software_Engineering.Software_Eng.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public void save(ProjectDTO projectDTO) {
        //(조건. entity 객체를 넘겨줘야 함)
        // 1. dto -> entity 변환
        // 2. repository의 save 메서드 호출
        ProjectEntity projectEntity = ProjectEntity.toProjectEntity(projectDTO);
        projectRepository.save(projectEntity);
    }

}
