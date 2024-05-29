package com.Software_Engineering.Software_Eng.repository;

import com.Software_Engineering.Software_Eng.entity.IssueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

public interface IssueRepository extends JpaRepository<IssueEntity,Long> {

}
=======
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IssueRepository extends JpaRepository<IssueEntity, Long> {
//    @Modifying
//    @Query(value = "update IssueEntity i set i.issueHits=i.issueHits+1 where i.id=:id")
//    void updateIssueHits(@Param("id") Long id);

}

>>>>>>> 94699e06d5c3e8d90d0e533efaa194ad7ed32ef5
