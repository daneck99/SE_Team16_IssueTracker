package com.Software_Engineering.Software_Eng.repository;

import com.Software_Engineering.Software_Eng.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//repository가 db와 상호작용 <>내용: 어떤 entity클래스를 다룰 것인지, pk의 type이 무엇인지
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 이메일로 회원 정보 조회
    Optional<MemberEntity> findByMemberEmail(String memberEmail);
}
