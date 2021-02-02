package com.kingjakeu.springstudy.domain.payment.aspect;

import com.kingjakeu.springstudy.domain.payment.dao.PaymentTxInfoRepository;
import com.kingjakeu.springstudy.domain.payment.domain.PaymentTxInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class RequestingPaymentAspect {

    private final PaymentTxInfoRepository paymentTxInfoRepository;

    // @RequestingPoint가 달린 메소드만 적용한다.
    @Before("@annotation(com.kingjakeu.springstudy.domain.payment.annotation.RequestingPayment)")
    public void onBefore(JoinPoint joinPoint) { // Joint Point가 실행되기 전
        PaymentTxInfo paymentTxInfo = (PaymentTxInfo)joinPoint.getArgs()[0];
        paymentTxInfo.setStatus("requesting");
        this.paymentTxInfoRepository.save(paymentTxInfo);
    }

    @AfterReturning("@annotation(com.kingjakeu.springstudy.domain.payment.annotation.RequestingPayment)")
    public void onAfterReturning(JoinPoint joinPoint){ // Joint Point가 실행된 후
        PaymentTxInfo paymentTxInfo = (PaymentTxInfo)joinPoint.getArgs()[0];
        paymentTxInfo.setStatus("success");
        this.paymentTxInfoRepository.save(paymentTxInfo);
    }

    @AfterThrowing("@annotation(com.kingjakeu.springstudy.domain.payment.annotation.RequestingPayment)")
    public void onAfterTrowing(JoinPoint joinPoint){// Joint Point가 실행되고 에러가 발생했을 때
        PaymentTxInfo paymentTxInfo = (PaymentTxInfo)joinPoint.getArgs()[0];
        paymentTxInfo.setStatus("failed");
        this.paymentTxInfoRepository.save(paymentTxInfo);
    }

    @Around("@annotation(com.kingjakeu.springstudy.domain.payment.annotation.RequestingPayment)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable { // JointPoint 실행 전, 후
        long currentTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        log.info(String.valueOf(System.currentTimeMillis() - currentTime));
        return proceed;
    }
}
