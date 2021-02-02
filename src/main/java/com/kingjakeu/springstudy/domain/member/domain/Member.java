package com.kingjakeu.springstudy.domain.member.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "MEMBER")
public class Member {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Long id;

    @Column(updatable = false, nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Setter
    @Column(nullable = false)
    private String statusCode;

    @Builder
    public Member(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
}
