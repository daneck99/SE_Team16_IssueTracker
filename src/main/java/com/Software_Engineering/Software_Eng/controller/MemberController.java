package com.Software_Engineering.Software_Eng.controller;

import com.Software_Engineering.Software_Eng.dto.MemberDTO;
import com.Software_Engineering.Software_Eng.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    @PostMapping("/members")
    public ResponseEntity<?> save(@RequestBody MemberDTO memberDTO) {
        memberService.save(memberDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/members/login")
    public ResponseEntity<?> login(@RequestBody MemberDTO memberDTO) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberDTO>> findAll() {
        List<MemberDTO> memberDTOList = memberService.findAll();
        return ResponseEntity.ok(memberDTOList);
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<MemberDTO> findById(@PathVariable Long id) {
        MemberDTO memberDTO = memberService.findById(id);
        if (memberDTO != null) {
            return ResponseEntity.ok(memberDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody MemberDTO memberDTO) {
        memberDTO.setId(id);
        memberService.update(memberDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        memberService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
