package com.Software_Engineering.Software_Eng.repository;

import com.Software_Engineering.Software_Eng.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
