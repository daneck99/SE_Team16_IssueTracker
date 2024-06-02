package com.Software_Engineering.Software_Eng.dto;

import com.Software_Engineering.Software_Eng.entity.Authorization;
import com.Software_Engineering.Software_Eng.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor//기본 생성자 생성 노테이션
@AllArgsConstructor // 모든 필드를 가지는 생성자 생성 노테이션
@ToString //
//회원 정보를 class로 정의
public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private Authorization memberAuth;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setMemberName(memberEntity.getMemberName());
        memberDTO.setMemberAuth(memberEntity.getMemberAuth());
        return memberDTO;
    }

}