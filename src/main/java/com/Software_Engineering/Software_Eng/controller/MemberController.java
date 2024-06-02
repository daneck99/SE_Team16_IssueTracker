package com.Software_Engineering.Software_Eng.controller;

import com.Software_Engineering.Software_Eng.dto.MemberDTO;
import com.Software_Engineering.Software_Eng.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class MemberController {
    //생성자 주입(일반 자바에서 다른 클래스 객체를 생성하고 그 객체의 메소드를 호출하는 방식의 스프링 버전)
    //컨트롤러 클래스가 서비스 클래스의 method를 관리할 수 있는 권한을 가지게 됨

    private final MemberService memberService;

    //회원가입 페이지 출력 요청, 링크를 타고 옴
    // 링크를 클릭-> Get method를 요청한다.
    // 요청에는 Get,post,Put,Delete,Patch 등 종류가 다양하게 있다.
    @GetMapping("/member/save")
    /* 현재 html에서 주소를 post방식으로 보냈는데 Get으로 받고 있기 때문에 405error가
     뜰 수 있음*/
    public String saveForm(){
//        return "save";
    // 이슈 작성 코드에서도 'save' 명의 html 파일을 사용하므로 코드 호출 시 회원 가입이 아닌
    // 이슈 글 작성 페이지로 넘어가게 됨. 따라서 두 html 파일을 명시적으로 분리해야 함.

        // 임시로 register란 이름의 html로 넘김 (내용은 멤버관리 브랜치의 save와 동일)
        return "register";
    }

    @PostMapping("/member/save")
    /*post 방식으로 받기 @RequestParam 에서 담아온 것을 type과 변수에 전달
     * soutp:매개변수를 println으로 자동완성해 줌 @ModelAttritute: class를 전달하는
     * 어노테이션 역할:
     * save에서 넘어온 name과 DTO의 필드가 동일하다면 spring이 DTO객체를 생성하고
     * setter를 통해 값 입력*/
    public String save(@ModelAttribute MemberDTO memberDTO) {
        //요청이 제대로 가고 있는지 확인
        System.out.println("MemeberController.save");
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);
        return "login";
    }

    @PostMapping("/member/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){
        // 로그인이 성공했을 떄만 결과를 넘긴다.
        MemberDTO loginResult = memberService.login(memberDTO);
        if(loginResult != null) {
            //login 성공
            session.setAttribute("loginEmail",loginResult.getMemberEmail());
            return "index";
        }else{
            //login 실패
            return "login";
        }
    }

    // 아래 요청이 오면 login 페이지를 띄우도록 함
    @GetMapping("/member/login")
    public String loginForm(){
        return "login";
    }
    // 주소값이 맞아야 함 맞지 않으면 404error가 뜨게 됨
    @GetMapping("/member/")
    public String findAll(Model model){
        //db에 저장된 내용 다 불러옴, DTOList의 데이터를 html로 전송해야 함
        List<MemberDTO> memberDTOList = memberService.findAll();
        //어떠한 html로 가져갈 데이터가 있다면 model사용
        model.addAttribute("memberList",memberDTOList);
        return "memberList";
    }

    @GetMapping("/member/{id}")
    //@PathVariable: rest api관련 , 경로 상에 있는 값을 가져올 때 사용
    //@RequestParam: query string 관련
    public String findById(@PathVariable Long id, Model model){
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member",memberDTO);
        return "detail";
    }

    @GetMapping("/member/update")
    public String updateForm(HttpSession session, Model model){
//        String myEmail = (String) session.getAttribute("loginEmail");
//        //컨트롤러에서 DTO로 myEmail값을 가져오고
//        MemberDTO memberDTO = memberService.updateForm(myEmail);
//        //updateMember에 담고
//        model.addAttribute("updateMember",memberDTO);
//        // update html로 간다
        return "update";
    }

    @PostMapping("/member/update")
    public String update(/*@ModelAttribute MemberDTO memberDTO*/){
        //수정이 완료된 상세페이지를 보여줘야 함.
//        memberService.update(memberDTO);
//        //return "detail";
//        //이렇게 되면 detail 부분이 텅텅비게 가게 됨.
//        return "redirect:/member/" + memberDTO.getId();
        //controller의 다른 메소드를 호출함 -> 결과적으로 내 정보 수정 후 수정된 상세페이지를 띄워준다.
        return "update";
    }

    @GetMapping("/member/delete/{id}")
    public String deleteById(@PathVariable Long id){
//        memberService.deleteById(id);
        return "redirect:/member/";
    }

    @GetMapping("/member/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }
}