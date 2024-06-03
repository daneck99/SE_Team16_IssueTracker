package com.Software_Engineering.Software_Eng.repository;

import com.Software_Engineering.Software_Eng.entity.ComponentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<ComponentEntity,Long> {
}
