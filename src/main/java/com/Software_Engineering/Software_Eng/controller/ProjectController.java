package com.Software_Engineering.Software_Eng.controller;

import com.Software_Engineering.Software_Eng.dto.ComponentDTO;
import com.Software_Engineering.Software_Eng.dto.ProjectDTO;
import com.Software_Engineering.Software_Eng.entity.ProjectEntity;
import com.Software_Engineering.Software_Eng.repository.ProjectRepository;
import com.Software_Engineering.Software_Eng.service.ComponentService;
import com.Software_Engineering.Software_Eng.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final ComponentService componentService;

    @GetMapping String saveForm(){return "/project";}
    @PostMapping("project")
    public String save(@ModelAttribute ProjectDTO projectDTO){
        //프로젝트 생성
        projectService.save(projectDTO);
        return "/project/{id}";
    }

    @GetMapping("project/{id}")
    public String findAll(@PathVariable Long projectId, Model model){
        //모든 프로젝트 보여주기
        List<ProjectDTO> projectDTOList = projectService.findAll();
        model.addAttribute("componentList",componentDTOList);

        return "redirect:/project";
    }
}
