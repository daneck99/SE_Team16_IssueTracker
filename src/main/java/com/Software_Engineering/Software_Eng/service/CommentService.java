package com.Software_Engineering.Software_Eng.service;

import com.Software_Engineering.Software_Eng.dto.CommentDTO;
import com.Software_Engineering.Software_Eng.entity.CommentEntity;
import com.Software_Engineering.Software_Eng.entity.IssueEntity;
import com.Software_Engineering.Software_Eng.repository.CommentRepository;
import com.Software_Engineering.Software_Eng.repository.IssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final IssueRepository issueRepository;

    public Long save(CommentDTO commentDTO) {
        Optional<IssueEntity> optionalIssueEntity = issueRepository.findById(commentDTO.getIssueId());
        if (optionalIssueEntity.isPresent()) {
            IssueEntity issueEntity = optionalIssueEntity.get();
            CommentEntity commentEntity = CommentEntity.toSaveEntity(commentDTO, issueEntity);

            return commentRepository.save(commentEntity).getId();
        }
        else{return null;}

    }

}
