package com.Software_Engineering.Software_Eng.service;

import com.Software_Engineering.Software_Eng.dto.IssueDTO;
import com.Software_Engineering.Software_Eng.entity.IssueEntity;
import com.Software_Engineering.Software_Eng.repository.IssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IssueService {
    private final IssueRepository issueRepository;

    public void write(IssueDTO issueDTO) {
        IssueEntity issueEntity = IssueEntity.toSaveEntity(issueDTO);
        issueRepository.save(issueEntity);
    }

    public List<IssueDTO> findAll() {
        List<IssueEntity> issueEntityList = issueRepository.findAll();
        List<IssueDTO> issueDTOList = new ArrayList<>();
        for (IssueEntity issueEntity : issueEntityList) {
            issueDTOList.add(IssueDTO.toIssueDTO(issueEntity));
        }
        return issueDTOList;
    }

    public IssueDTO findById(Long id) {
        Optional<IssueEntity> optionalIssueEntity = issueRepository.findById(id);
        if(optionalIssueEntity.isPresent()) {
            IssueEntity issueEntity = optionalIssueEntity.get();
            IssueDTO issueDTO = IssueDTO.toIssueDTO(issueEntity);
            return issueDTO;
        }
        return null;
    }

    public IssueDTO update(IssueDTO issueDTO) {
        IssueEntity issueEntity = IssueEntity.toUpdateEntity(issueDTO);
        issueRepository.save(issueEntity);
        return findById(issueDTO.getId());
    }

    public void delete(Long id) {
        issueRepository.deleteById(id);
    }

    public Page<IssueDTO> paging(Pageable pageable) {
        int page = pageable.getPageNumber() -1;
        int pageLimit = 3; // n issues per 1 page

        Page<IssueEntity> issueEntities = issueRepository.findAll(PageRequest.of(page,
                pageLimit, Sort.by(Sort.Direction.DESC,"id")));

        System.out.println("issueEntities.getContent() = " + issueEntities.getContent()); // 요청 페이지에 해당하는 글
        System.out.println("issueEntities.getTotalElements() = " + issueEntities.getTotalElements()); // 전체 글갯수
        System.out.println("issueEntities.getNumber() = " + issueEntities.getNumber()); // DB로 요청한 페이지 번호
        System.out.println("issueEntities.getTotalPages() = " + issueEntities.getTotalPages()); // 전체 페이지 갯수
        System.out.println("issueEntities.getSize() = " + issueEntities.getSize()); // 한 페이지에 보여지는 글 갯수
        System.out.println("issueEntities.hasPrevious() = " + issueEntities.hasPrevious()); // 이전 페이지 존재 여부
        System.out.println("issueEntities.isFirst() = " + issueEntities.isFirst()); // 첫 페이지 여부
        System.out.println("issueEntities.isLast() = " + issueEntities.isLast()); // 마지막 페이지 여부

        // id, writer, title, createdTime
        Page<IssueDTO> issueDTOS = issueEntities.map(issue ->
                new IssueDTO(issue.getId(),issue.getIssueTitle(),
                        issue.getIssueWriter(),issue.getCreatedTime()));

        return issueDTOS;
    }

//    @Transactional
//    public void updateHits(Long id){
//        issueRepository.updateIssueHits(id);
//    }
}
