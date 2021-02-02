package com.kingjakeu.springstudy.domain.member.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Before("@annotation(com.kingjakeu.springstudy.domain.member.annotation.LogExecutionTime)")
    public void before(JoinPoint joinPoint){
        log.info("BEFORE");
    }
    @After("@annotation(com.kingjakeu.springstudy.domain.member.annotation.LogExecutionTime)")
    public void after(JoinPoint joinPoint){
        log.info("AFTER");
    }

    @AfterReturning("@annotation(com.kingjakeu.springstudy.domain.member.annotation.LogExecutionTime)")
    public void afterReturning(JoinPoint joinPoint){
        log.info("AFTER RETURNING");
    }

    @Around("@annotation(com.kingjakeu.springstudy.domain.member.annotation.LogExecutionTime)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("AROUND-1");
        Object proceed = joinPoint.proceed();
        log.info("AROUND-2");
        return proceed;
    }
}
