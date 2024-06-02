package com.Software_Engineering.Software_Eng.repository;

import com.Software_Engineering.Software_Eng.entity.BoardEntity;
import com.Software_Engineering.Software_Eng.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    // select * from comment_table where board_id=? order by id desc;
    List<CommentEntity> findAllByBoardEntityOrderByIdDesc(BoardEntity boardEntity);
}