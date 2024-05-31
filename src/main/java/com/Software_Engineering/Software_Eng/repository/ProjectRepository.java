package com.Software_Engineering.Software_Eng.repository;

import com.Software_Engineering.Software_Eng.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity,Long> {

}
