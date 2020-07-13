package com.kingjakeu.springstudy.domain.member.dao;

import com.kingjakeu.springstudy.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
