package com.kingjakeu.springstudy.domain.member.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Long id;

    @Column(updatable = false, nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Builder
    public Member(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
}
