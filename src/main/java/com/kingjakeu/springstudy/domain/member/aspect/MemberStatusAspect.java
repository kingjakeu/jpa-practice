package com.kingjakeu.springstudy.domain.member.aspect;

import com.kingjakeu.springstudy.domain.member.dao.MemberRepository;
import com.kingjakeu.springstudy.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class MemberStatusAspect {

    private final MemberRepository memberRepository;

    @Before("@annotation(com.kingjakeu.springstudy.domain.member.annotation.MemberStatusLog)")
    public void onBefore(JoinPoint joinPoint){
        Member member = (Member) joinPoint.getArgs()[0];
        member.setStatusCode("01");
        log.info("before");
    }

    @AfterReturning("@annotation(com.kingjakeu.springstudy.domain.member.annotation.MemberStatusLog)")
    public void onAfterReturning(JoinPoint joinPoint){
        Member member = (Member) joinPoint.getArgs()[0];
        member.setStatusCode("10");
        memberRepository.save(member);
        log.info("after returning");
    }
    @AfterThrowing("@annotation(com.kingjakeu.springstudy.domain.member.annotation.MemberStatusLog)")
    public void onAfterTrowing(JoinPoint joinPoint){
        Member member = (Member) joinPoint.getArgs()[0];
        member.setStatusCode("40");
        memberRepository.save(member);
        log.info("after throwing");
    }
}
