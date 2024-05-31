package com.Software_Engineering.Software_Eng.repository;

import com.Software_Engineering.Software_Eng.entity.ComponentEntity;
import com.Software_Engineering.Software_Eng.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponentRepository extends JpaRepository<ComponentEntity, Long> {
    List<ComponentEntity> findAllByProjectEntityOrderByIdDesc(ProjectEntity projectEntity);
}
