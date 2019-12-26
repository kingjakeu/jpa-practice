package com.kingjakeu.domain.member.dao;


import com.kingjakeu.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
