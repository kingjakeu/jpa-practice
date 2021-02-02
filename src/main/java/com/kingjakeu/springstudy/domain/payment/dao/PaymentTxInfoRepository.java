package com.kingjakeu.springstudy.domain.payment.dao;

import com.kingjakeu.springstudy.domain.payment.domain.PaymentTxInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTxInfoRepository extends JpaRepository<PaymentTxInfo, Long> {
}
