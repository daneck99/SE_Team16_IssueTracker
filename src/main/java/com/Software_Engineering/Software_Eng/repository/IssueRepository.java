package com.Software_Engineering.Software_Eng.repository;

import com.Software_Engineering.Software_Eng.entity.IssueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class IssueRepository implements JpaRepository<IssueEntity,Long> {
}
