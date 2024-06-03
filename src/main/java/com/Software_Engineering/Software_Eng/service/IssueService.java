package com.Software_Engineering.Software_Eng.service;

import com.Software_Engineering.Software_Eng.dto.IssueDTO;
import com.Software_Engineering.Software_Eng.entity.IssueEntity;
import com.Software_Engineering.Software_Eng.entity.MemberEntity;
import com.Software_Engineering.Software_Eng.repository.IssueRepository;
import com.Software_Engineering.Software_Eng.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IssueService {
    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private MemberRepository memberRepository;

    public List<IssueDTO> getAllIssues(Long componentId) {
        return issueRepository.findById(componentId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public IssueDTO getIssueById(Long id) {
        return issueRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public IssueDTO createIssue(Long componentId, IssueDTO issueDTO, String fixerEmail,String repoerterEmail) {
        IssueEntity issue = new IssueEntity();
        Optional<MemberEntity> optional1 = memberRepository.findByMemberEmail(fixerEmail);
        MemberEntity fixer = optional1.get();
        if(fixer!=null){
            issue.setFixerEmail(fixer.getMemberEmail());
        }
        Optional<MemberEntity> optional2 = memberRepository.findByMemberEmail(repoerterEmail);
        MemberEntity reporter = optional2.get();
        if(reporter!=null){
            issue.setReporterEmail(reporter.getMemberEmail());
        }
        issue.setIssueTitle(issueDTO.getIssueTitle());
        issue.setIssueContents(issueDTO.getIssueContents());
        issue.setComponentId(componentId);
        issue.setReporterEmail(member.getMemberEmail());


        issueRepository.save(issue);
        return convertToDTO(issue);
    }

    public IssueDTO updateIssue(IssueDTO issueDTO) {
        IssueEntity issue = issueRepository.findById(issueDTO.getId()).orElse(null);
        if (issue != null) {
            issue.setTitle(issueDTO.getTitle());
            issue.setDescription(issueDTO.getDescription());
            issueRepository.save(issue);
            return convertToDTO(issue);
        }
        return null;
    }

    public void deleteIssue(Long id) {
        issueRepository.deleteById(id);
    }

    private IssueDTO convertToDTO(IssueEntity issue) {
        IssueDTO issueDTO = new IssueDTO();
        issueDTO.setId(issue.getId());
        issueDTO.setIssueTitle(issue.getIssueTitle());
        issueDTO.setIssueContents(issue.getIssueContents());
        issueDTO.setComponentId(issue.getComponent().getId());
        issueDTO.setReporterId(issue.getReporterId().getId());
        issueDTO.setFixerId(issue.getFixer().getId());
        return issueDTO;
    }
}
