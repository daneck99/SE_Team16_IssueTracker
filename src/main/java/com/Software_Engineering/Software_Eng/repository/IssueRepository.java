package com.Software_Engineering.Software_Eng.repository;

import com.Software_Engineering.Software_Eng.entity.IssueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<IssueEntity,Long> {

}
