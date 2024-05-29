package com.Software_Engineering.Software_Eng.repository;

import com.Software_Engineering.Software_Eng.entity.IssueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IssueRepository extends JpaRepository<IssueEntity, Long> {
//    @Modifying
//    @Query(value = "update IssueEntity i set i.issueHits=i.issueHits+1 where i.id=:id")
//    void updateIssueHits(@Param("id") Long id);

}

