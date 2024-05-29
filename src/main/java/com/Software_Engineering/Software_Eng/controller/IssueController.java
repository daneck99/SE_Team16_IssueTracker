package com.Software_Engineering.Software_Eng.controller;

import com.Software_Engineering.Software_Eng.dto.IssueDTO;
import com.Software_Engineering.Software_Eng.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/issue")
public class IssueController {
    private final IssueService issueService;

    // writing is saving issue in DB
    @GetMapping("/write")
    public String writeIssue() {
        return "write";
    }

    @PostMapping("/write")
    public String writeIssue(@ModelAttribute IssueDTO issueDTO){
        System.out.println("issueDTO = " + issueDTO);
        issueService.write(issueDTO);

        return "index";
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<IssueDTO> issueDTOList = issueService.findAll();
        model.addAttribute("issueList", issueDTOList);
        return "list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model,
                           @PageableDefault(page = 1) Pageable pageable) {
        //issueService.updateHits(id);
        IssueDTO issueDTO = issueService.findById(id);
        model.addAttribute("issue", issueDTO);
        model.addAttribute("page", pageable.getPageNumber());
        return "detail";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        IssueDTO issueDTO = issueService.findById(id);
        model.addAttribute("issueUpdate", issueDTO);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute IssueDTO issueDTO, Model model) {
        IssueDTO issue = issueService.update(issueDTO);
        model.addAttribute("issue", issue);
        return "detail";
//        return "redirect:/issue/" + issue.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        issueService.delete(id);
        return "redirect:/issue/";
    }

    @GetMapping("/paging")
    public String findAllPaging(@PageableDefault(page = 1) Pageable pageable, Model model) {
//      pageable.getPageNumber();
        Page<IssueDTO> issueList = issueService.paging(pageable);

        int blockLimit = 3; // n pages index can show
        int startPage = (((int)(Math.ceil((double)pageable.getPageNumber() / blockLimit))) - 1) * blockLimit + 1; // 1 4 7 10 ~~
        int endPage = ((startPage + blockLimit - 1) < issueList.getTotalPages()) ? startPage + blockLimit - 1 : issueList.getTotalPages();

        model.addAttribute("issueList", issueList);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "paging";
    }

}
