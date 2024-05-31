package com.Software_Engineering.Software_Eng.controller;

import com.Software_Engineering.Software_Eng.dto.ComponentDTO;
import com.Software_Engineering.Software_Eng.entity.ComponentEntity;
import com.Software_Engineering.Software_Eng.service.ComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ComponentController {
    private final ComponentService componentService;

    @GetMapping String saveForm(){return "/member/{id}/project/{id}/component"}
    @PostMapping("/member/{id}/project/{id}/component")
    public String save(@ModelAttribute ComponentDTO componentDTO){
        //component 생성
        componentService.save(componentDTO);
        return "/member/{id}/project/{id}/component/";
    }


}
