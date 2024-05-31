package com.Software_Engineering.Software_Eng.service;

import com.Software_Engineering.Software_Eng.dto.MemberDTO;
import com.Software_Engineering.Software_Eng.entity.MemberEntity;
import com.Software_Engineering.Software_Eng.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//db 작업이 필요한 경우 Service를 거치게 된다.
@Service
//@serivce : spring이 관리해주는 객체(spring bean)로 등록한다는 의미
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
        //(조건. entity 객체를 넘겨줘야 함)
        // 1. dto -> entity 변환
        // 2. repository의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        /*
        1.  회원이 입력한 이메일로 DB에서 조회를 함
        2.  DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
        */
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if(byMemberEmail.isPresent()) {
            //조회 결과가 있다
            MemberEntity memberEntity = byMemberEmail.get();
            if(memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())){
                //비밀번호 일치
                //entity ->dto 변환 후 일치
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else{
                //비밀번호 불일치
                return null;
            }
        }else{
            //조회 결과가 없다
            return null;
        }
    }

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for(MemberEntity memberEntity:memberEntityList){
            memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
        }
        return memberDTOList;
    }

    public MemberDTO findById(Long id) {
        //보통 하나를 조회할 때는 repository에서 optional 객체로 감싸서 넘겨줌
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
        if(optionalMemberEntity.isPresent()){
            //Optional 객체를 까려면 get이 필요, 까면 Entity가 나오고, DTO로 변환해서 전달
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        }else{
            return null;
        }
    }

    public MemberDTO updateForm(String myEmail) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberEmail(myEmail);
        if(optionalMemberEntity.isPresent()){
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        }else{
            return null;
        }
    }

    public void update(MemberDTO memberDTO) {
        //save method는 id가 없으면 insert 쿼리 수행, db에 id가 있는 entity가 날아오면 update 쿼리 수행
        memberRepository.save(MemberEntity.toUpdateMemberEntity(memberDTO));
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
//    public String emailCheck(String memberEmail) {
//        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberEmail);
//        if (byMemberEmail.isPresent()) {
//            // 조회결과가 있다 -> 사용할 수 없다.
//            return null;
//        } else {
//            // 조회결과가 없다 -> 사용할 수 있다.
//            return "ok";
//        }
//    }
}
