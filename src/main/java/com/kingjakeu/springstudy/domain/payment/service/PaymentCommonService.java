package com.kingjakeu.springstudy.domain.payment.service;

import com.kingjakeu.springstudy.domain.payment.annotation.RequestingPayment;
import com.kingjakeu.springstudy.domain.payment.domain.PaymentTxInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentCommonService {

    @RequestingPayment
    public void requestCardPayment(PaymentTxInfo paymentTxInfo){
        // 카드 결제 요청
    }
}
