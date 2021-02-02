package com.kingjakeu.springstudy.domain.payment.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "PAY_TX_INFO")
public class PaymentTxInfo {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    private String merchantId;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private String paymentKey;

    @Setter
    @Column(nullable = false)
    private String status;
}
